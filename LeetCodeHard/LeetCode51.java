package LeetCodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[][] boardBoolean = new boolean[n][n];
        boolean[] booleaninitialize = new boolean[n];
        char[] initialize = new char[n];
        for(int i=0;i<n;i++){
            initialize[i] = '.';
        }
        for(int i=0;i<n;i++){
            board[i] = Arrays.copyOf(initialize, n);
            boardBoolean[i] = Arrays.copyOf(booleaninitialize, n);
        }
        backtrack(result, board, boardBoolean, 0);
        return result;
    }

    public static void main(String[] args) {
        int n = 1;
        LeetCode51 obj = new LeetCode51();
        System.out.println("Number of Queens -> "+n);
        System.out.println("Possible Combinations ->\n"+obj.solveNQueens(n));
    }

    public void backtrack(List<List<String>> result, char[][] board, boolean[][] boardBoolean, int p){
        if(p>=board.length) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                res.add(new String(board[i]));
            }
            result.add(res);
        }
        else{
            for(int i=0;i<board.length;i++){
                if(boardBoolean[p][i])
                    continue;
                else{
                    boolean[][] copy = new boolean[board.length][board.length];
                    for(int k = p+1; k< board.length;k++){
                        copy[k] = Arrays.copyOf(boardBoolean[k], board.length);
                    }
                    board[p][i] = 'Q';
                    boardBoolean[p][i] = true;
                    int a = p+1;
                    int b1 = i+1;
                    int b2 = i-1;
                    while(a< board.length){
                        if(b1< board.length && b1>=0)
                            boardBoolean[a][b1++] = true;
                        if(b2< board.length && b2>=0)
                            boardBoolean[a][b2--] = true;
                        boardBoolean[a++][i] = true;
                    }
                    backtrack(result, board, boardBoolean, p+1);
                    for(int k = p+1;k< board.length;k++){
                        boardBoolean[k] = Arrays.copyOf(copy[k], board.length);
                    }
                    boardBoolean[p][i] = false;
                    board[p][i] = '.';
                }
            }
        }
    }

    void display(char[][] board){
        System.out.println("Board Rn -> ");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
