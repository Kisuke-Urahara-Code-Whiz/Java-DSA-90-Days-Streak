package LeetCodeEasy;

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode645 {
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
        int [] arr2 = mismatch(arr);
        display(arr2);
    }


    public static void sort(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            int correct = arr[index] - 1;
            if (arr[correct] == arr[index])
                index++;
            else
                swap(arr, correct, index);
        }
        System.out.println("Duplicate number = " + arr[arr.length-1]);
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void display(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static int[] mismatch(int[] arr){
        int arr2[] = new int[2];
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=(i+1)){
                arr2[0]=arr[i];
                arr2[1]=i+1;
            }
        }
        return arr2;
    }
}