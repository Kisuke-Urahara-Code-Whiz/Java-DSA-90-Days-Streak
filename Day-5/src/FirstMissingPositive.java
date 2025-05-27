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