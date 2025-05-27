//LEETCODE EASY
//645. Set Mismatch
//        You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
//        You are given an integer array nums representing the data status of this set after the error.
//
//        Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,2,4]
//        Output: [2,3]
//        Example 2:
//
//        Input: nums = [1,1]
//        Output: [1,2]
//
//
//        Constraints:
//
//        2 <= nums.length <= 104
//        1 <= nums[i] <= 104

import java.util.Arrays;
import java.util.Scanner;

public class SetMismatch {
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