package LeetCodeMedium;

public class LeetCode743 {

    static class Heap{
        int[][] heap;
        int top;

        Heap(int size){
            heap = new int[size+1][2];
            top = 0;
        }

        void swap(int p1, int p2){
            int[] temp = heap[p1];
            heap[p1] = heap[p2];
            heap[p2] = temp;
        }

        boolean isEmpty(){
            return top==0;
        }

        int[] delete(){
            swap(1, top);
            int[] result = heap[top--];

            int index = 1;
            while(2*index<=top){
                int lIndex = 2*index;
                if(lIndex+1<=top && heap[lIndex][1]>heap[lIndex+1][1]) lIndex++;
                if(heap[lIndex][1]<heap[index][1]){
                    swap(lIndex, index);
                    index = lIndex;
                } else break;
            }

            return result;
        }

        void add(int[] item){
            heap[++top] = item;
            int index = top;
            while(index/2!=0){
                if(heap[index][1]<heap[index/2][1]){
                    swap(index, index/2);
                    index = index/2;
                } else break;
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] reached = new boolean[n+1];
        int destinations = 0;
        int result = Integer.MIN_VALUE;
        int[][] graph = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i!=j) graph[i][j] = -1;
            }
        }

        for(int[] i: times){
            graph[i[0]][i[1]] = i[2];
        }

        Heap heap = new Heap(times.length+1);
        heap.add(new int[]{k, 0});

        while(!heap.isEmpty()){
            int[] item = heap.delete();
            if(!reached[item[0]]){
                int newNode = item[0];
                reached[item[0]] = true;
                result = Math.max(item[1], result);
                if(++destinations == n) break;
                for(int i=0;i<=n;i++){
                    if(i!=newNode && !reached[i] &&graph[newNode][i]!=-1)
                        heap.add(new int[]{i, item[1]+graph[newNode][i]});
                }
            }
        }

        if(n!=destinations) return -1;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode743().networkDelayTime(
                new int[][]{
                        {2,1,3},{2,3,1},{3,4,1}
                }, 4, 2
        ));
    }

}
