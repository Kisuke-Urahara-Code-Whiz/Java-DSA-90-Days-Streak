package LeetCodeEasy;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode268 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of integers in the array : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter value for index " + i + " : ");
            arr[i] = sc.nextInt();
        }
        System.out.println("Original array : ");
        display(arr);
        sort(arr);
        int missing = n;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i)
                missing = i;
        }
        System.out.println("The missing number is " + missing);
    }

    public static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void sort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            int correct = arr[index];
            if (correct != arr.length) {
                if (arr[correct] == arr[index])
                    index++;
                else
                    swap(arr, correct, index);
            } else
                index++;

        }
    }
}
