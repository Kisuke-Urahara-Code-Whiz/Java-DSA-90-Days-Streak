package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode542 {

    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> xQueue = new ArrayDeque<>();
        Queue<Integer> yQueue = new ArrayDeque<>();

        int m = mat.length;
        int n = mat[0].length;
        int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    xQueue.add(i);
                    yQueue.add(j);
                } else mat[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!xQueue.isEmpty()) {
            int tempX = xQueue.remove();
            int tempY = yQueue.remove();
            int val = mat[tempX][tempY];

            for (int[] i : directions) {
                int newX = tempX + i[0];
                int newY = tempY + i[1];
                if (newX < m && newY < n && newX >= 0 && newY >= 0 && mat[newX][newY] > val + 1) {
                    mat[newX][newY] = val + 1;
                    xQueue.add(newX);
                    yQueue.add(newY);
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        new LeetCode542().updateMatrix(
        new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
            }
        );
    }

}
