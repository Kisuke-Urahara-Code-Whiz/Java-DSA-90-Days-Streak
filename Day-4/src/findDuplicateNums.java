// Array of n integers
// contain integers from [1,n]
// each integer appears once or twice

import java.util.Arrays;
import java.util.Scanner;

public class findDuplicateNums {
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
            System.out.println("Invalid numbers entered in the array. Array must contain only [1,n] numbers and each integer appears once or twice");
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
        System.out.println("Duplicate Numbers in the array are : ");
        while(index!=arr.length){
            if(arr[index]!=(index+1)) {
                System.out.println(arr[index]);
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