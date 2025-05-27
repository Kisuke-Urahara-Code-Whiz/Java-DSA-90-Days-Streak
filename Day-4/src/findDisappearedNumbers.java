//448. Find All Numbers Disappeared in an Array
//        Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
//
//
//
//        Example 1:
//
//        Input: nums = [4,3,2,7,8,2,3,1]
//        Output: [5,6]
//        Example 2:
//
//        Input: nums = [1,1]
//        Output: [2]
//
//
//        Constraints:
//
//        n == nums.length
//        1 <= n <= 105
//        1 <= nums[i] <= n
//
//
//        Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

import java.util.Arrays;
import java.util.Scanner;

public class findDisappearedNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of integers in the array : ");
        int n =  sc.nextInt();
        int[] arr  = new int[n];
        for(int i=0;i<n;i++) {
            System.out.println("Enter value for index "+i+" : ");
            arr[i]=sc.nextInt();
        }
        System.out.println("Original array : ");
        display(arr);
        if(checkCorrect(arr)){
            findDisappeared(arr);
        }
        else{
            System.out.println("Invalid numbers entered in the array. Array must contain only [1,n] numbers");
        }
    }

    public static boolean checkCorrect(int[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr.length)
                return false;
        }
        return true;
    }

    public static void findDisappeared(int[] arr){
        int index = 0;
        while(index<arr.length){
            int correct = arr[index]-1;
            if(arr[correct]==arr[index])
                index++;
            else
                swap(arr,correct,index);
        }
        check(arr);
    }

    public static void check(int[] arr){
        int index = 0;
        int count = 0;
        System.out.println("Disappeared Numbers in the array are : ");
        while(index!=arr.length){
            if(arr[index]!=(index+1)) {
                System.out.println(index + 1);
                count++;
            }
            index++;
        }
        if(count==0){
            System.out.println("No number is missing");
        }
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    public static void display(int[] arr){
        System.out.println(Arrays.toString(arr));
    }
}