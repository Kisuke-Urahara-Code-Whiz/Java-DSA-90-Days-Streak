package LeetCodeMedium;

import java.util.ArrayList;

public class LeetCode73 {
    public static void main(String[] args) {
        int matrix[][] = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        System.out.println("Original Matrix : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Integer> rowTracker = new ArrayList<>();
        ArrayList<Integer> columnTracker = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!rowTracker.contains(i))
                        rowTracker.add(i);
                    if (!columnTracker.contains(j))
                        columnTracker.add(j);
                }
            }
        }

        for (int i : rowTracker) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }

        for (int i : columnTracker) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][i] = 0;
            }
        }

        System.out.println("\nFinal Matrix : ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
