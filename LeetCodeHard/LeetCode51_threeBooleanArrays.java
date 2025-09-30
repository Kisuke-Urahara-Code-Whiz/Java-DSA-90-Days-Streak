package LeetCodeHard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LeetCode51_threeBooleanArrays {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) Arrays.fill(board[i], '.');

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];

        backtrack(result, board, 0, cols, diag1, diag2, n);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row,
                           boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (int i=0; i<n; i++) solution.add(new String(board[i]));
            result.add(solution);
            return;
        }

        for (int col=0; col<n; col++) {
            if (cols[col] || diag1[row-col+n] || diag2[row+col]) continue;

            board[row][col] = 'Q';
            cols[col] = diag1[row-col+n] = diag2[row+col] = true;

            backtrack(result, board, row+1, cols, diag1, diag2, n);

            board[row][col] = '.';
            cols[col] = diag1[row-col+n] = diag2[row+col] = false;
        }
    }


}

