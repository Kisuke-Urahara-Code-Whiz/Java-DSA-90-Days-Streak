//LEETCODE HARD
//41. First Missing Positive
//        Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
//
//        You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
//
//
//
//        Example 1:
//
//        Input: nums = [1,2,0]
//        Output: 3
//        Explanation: The numbers in the range [1,2] are all in the array.
//        Example 2:
//
//        Input: nums = [3,4,-1,1]
//        Output: 2
//        Explanation: 1 is in the array but 2 is missing.
//        Example 3:
//
//        Input: nums = [7,8,9,11,12]
//        Output: 1
//        Explanation: The smallest positive integer 1 is missing.
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        -231 <= nums[i] <= 231 - 1

import java.util.Arrays;
import java.util.Scanner;

public class FirstMissingPositive {
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
        System.out.println(Arrays.toString(arr));
        sort(arr);
        int missing = checkMissing(arr);
        if(missing == 0)
            System.out.println("No missing number here.");
        else
            System.out.println(missing+" is the first missing positive");
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void sort(int[] arr){
        int index = 0;
        while(index<arr.length){
            int correct = arr[index]-1;
            if(arr[index]<=0 || arr[index]>arr.length)
                index++;
            else if(arr[correct]==arr[index])
                index++;
            else
                swap(arr, correct, index);
        }
    }

    public static int checkMissing(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=(i+1)){
                return (i+1);
            }
        }
        return 0;
    }
}