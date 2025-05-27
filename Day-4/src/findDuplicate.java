//287. Find the Duplicate Number
//        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//        There is only one repeated number in nums, return this repeated number.
//
//        You must solve the problem without modifying the array nums and using only constant extra space.
//
//
//
//        Example 1:
//
//        Input: nums = [1,3,4,2,2]
//        Output: 2
//        Example 2:
//
//        Input: nums = [3,1,3,4,2]
//        Output: 3
//        Example 3:
//
//        Input: nums = [3,3,3,3,3]
//        Output: 3
//
//
//        Constraints:
//
//        1 <= n <= 105
//        nums.length == n + 1
//        1 <= nums[i] <= n
//        All the integers in nums appear only once except for precisely one integer which appears two or more times.
//
//
//        Follow up:
//
//        How can we prove that at least one duplicate number must exist in nums?
//        Can you solve the problem in linear runtime complexity?

import java.util.Arrays;
import java.util.Scanner;

public class findDuplicate {
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
        if (checkCorrect(arr)) {
            findDuplicateNum(arr);
        } else {
            System.out.println("Invalid numbers entered in the array. Array must contain only [1,n] distinct numbers with or without only one double");
        }
    }

    public static boolean checkCorrect(int[] arr) {
        int arr2[] = new int[arr.length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr.length-1)
                return false;
            else {
                for(int j=0;j<arr.length;j++) {
                    if (arr[i] == arr2[j]){
                        count++;
                        if(count>1)
                            return false;
                    }
                }
            }
            arr2[i] = arr[i];
        }
        return true;
    }

    public static void findDuplicateNum(int[] arr) {
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
}

