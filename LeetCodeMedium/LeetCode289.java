package LeetCodeMedium;

public class LeetCode289 {
    public void gameOfLife(int[][] board) {

        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];
        for(int i=0;i<board.length;i++){
            System.arraycopy(board[i], 0, copy[i], 0, n);
        }

        int[][] directions = new int[][]{
                {-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{0,1},{1,1},{-1,1}
        };

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int live = 0;
                for(int[] k: directions){
                    int tempX = i+k[0];
                    int tempY = j+k[1];
                    if(tempX<m && tempX>=0 && tempY<n && tempY>=0 && copy[tempX][tempY]==1) live++;
                }
                if(copy[i][j]==0 && live==3) board[i][j] = 1;
                else if(copy[i][j]==1 && (live<2 || live>3)) board[i][j] = 0;
            }
        }
    }
}
