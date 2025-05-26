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
        System.out.println("Test array : ");
        display(arr);
        check(arr);
    }

    public static void check(int[] arr) {
        int index = 0;
        int count = 0;
        System.out.println("Disappeared Numbers in the array are : ");
        while (index != arr.length) {
            if (arr[index] != (index + 1)) {
                System.out.println(index + 1);
                count++;
            }
            index++;
        }
        if (count == 0) {
            System.out.println("No number is missing");
        }
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

