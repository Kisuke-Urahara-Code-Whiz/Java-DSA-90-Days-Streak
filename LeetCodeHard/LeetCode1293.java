package LeetCodeHard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1293 {

    public int shortestPath(int[][] grid, int k) {
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        Queue<Integer> kQueue = new LinkedList<>();
        Queue<Integer> stepsQueue = new LinkedList<>();

        int[][] directions = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int m = grid.length;
        int n = grid[0].length;

        int[][] visited = new int[m][n];
        for(int[] i: visited){
            Arrays.fill(i,-1);
        }

        visited[0][0] = k;
        xQueue.add(0);
        yQueue.add(0);
        kQueue.add(k);
        stepsQueue.add(0);

        int levelLength = xQueue.size();

        while(!xQueue.isEmpty()){
            while(levelLength!=0){
                int tempX = xQueue.remove();
                int tempY = yQueue.remove();
                int tempK = kQueue.remove();
                int tempSteps = stepsQueue.remove();

                if(tempX==m-1 && tempY==n-1 && tempK>=0) return tempSteps;

                for(int[] i: directions){
                    int newX = tempX+i[0];
                    int newY = tempY+i[1];
                    int newK = tempK;

                    if(newX>=0 && newY>=0 && newX<m && newY<n){
                        if(grid[newX][newY]==1 && tempK==0) continue;
                        else if(grid[newX][newY]==1) newK-=1;

                        if(visited[newX][newY]==-1 || visited[newX][newY]<newK) {
                            xQueue.add(newX);
                            yQueue.add(newY);
                            kQueue.add(newK);
                            stepsQueue.add(tempSteps + 1);
                            visited[newX][newY] = newK;
                        }

                    }
                }
                levelLength-=1;
            }
            levelLength = xQueue.size();
        }

        return -1;
    }

}
