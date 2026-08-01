package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode1765 {

    public int[][] highestPeak(int[][] isWater) {
        Queue<Integer> xQueue = new ArrayDeque<>();
        Queue<Integer> yQueue = new ArrayDeque<>();

        int m = isWater.length;
        int n = isWater[0].length;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    xQueue.add(i);
                    yQueue.add(j);
                    isWater[i][j] = 0;
                } else isWater[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!xQueue.isEmpty()){
            int tempX = xQueue.remove();
            int tempY = yQueue.remove();
            int val = isWater[tempX][tempY];

            for(int[] i: directions){
                int newX = tempX+i[0];
                int newY = tempY+i[1];
                if (newX < m && newY < n && newX >= 0 && newY >= 0 && isWater[newX][newY] > val+1){
                    isWater[newX][newY] = val+1;
                    xQueue.add(newX);
                    yQueue.add(newY);
                }
            }
        }

        return isWater;
    }

}
