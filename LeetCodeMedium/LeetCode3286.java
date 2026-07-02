package LeetCodeMedium;

import java.util.List;

public class LeetCode3286 {

    public static class Heap{
        int[] x;
        int[] y;
        int[] weights;
        int size;
        int top;

        Heap(int size){
            this.size = size+1;
            this.x = new int[size+1];
            this.y = new int[size+1];
            this.weights = new int[size+1];
            this.top = 1;
        }

        public void swap(int p1, int p2){

            int temp;

            temp = x[p1];
            x[p1] = x[p2];
            x[p2] = temp;

            temp = y[p1];
            y[p1] = y[p2];
            y[p2] = temp;

            temp = weights[p1];
            weights[p1] = weights[p2];
            weights[p2] = temp;

        }

        public void add(int x, int y, int weight){
            this.x[top] = x;
            this.y[top] = y;
            weights[top] = weight;

            int index = top++;

            while(index/2>0){
                if(weights[index]<weights[index/2]){
                    swap(index, index/2);
                    index = index/2;
                } else break;
            }
        }

        public int[] delete(){

            int[] result = new int[]{
                    x[1], y[1], weights[1]
            };

            swap(1, --top);

            int index = 1;
            while(index*2<top){
                int lIndex = index*2;
                if(lIndex+1<top && weights[lIndex+1]<weights[lIndex]) lIndex+=1;
                if(weights[index]>weights[lIndex]){
                    swap(index, lIndex);
                    index = lIndex;
                } else break;
            }

            return result;
        }

        public boolean isEmpty(){
            return this.top == 1;
        }

    }

    int m;
    int n;
    int[][] directions;
    boolean[][] visited;

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        m = grid.size();
        n = grid.getFirst().size();
        visited = new boolean[m][n];
        directions = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };

        Heap heap = new Heap(m*n);
        heap.add(0,0, grid.getFirst().getFirst());
        int totalCost = 0;

        while(!heap.isEmpty()){
            int[] result = heap.delete();
            int x = result[0];
            int y = result[1];
            int cost = result[2];
            if(x==m-1 && y==n-1){
                totalCost = cost;
                break;
            }

            if (visited[x][y]) continue;
            visited[x][y] = true;

            for(int[] i: directions){
                int newX = x+i[0];
                int newY = y+i[1];
                if(newX>=0 && newY>=0 && newX<m && newY<n && !visited[newX][newY]){
                    heap.add(newX, newY, cost+grid.get(newX).get(newY));
                }
            }
        }

        return totalCost < health;

    }

}
