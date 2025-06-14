import java.util.Arrays;
import java.util.Scanner;

public class Cyclic_Sort {
    public static void main(String[] args) {
//        System.out.println("Enter the size of n : ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        System.out.println("Enter all the elements of the array : ");
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {1, 2, 3, 5, 4};


        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]){
        int i = 0;
        while(i!=arr.length-1){
            if(arr[i]!=i+1){
                swap(arr,arr[i]-1,i);
            }
            else{
                i+=1;
            }
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}