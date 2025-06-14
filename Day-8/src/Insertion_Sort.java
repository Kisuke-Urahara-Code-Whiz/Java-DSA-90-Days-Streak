import java.util.Arrays;
import java.util.Scanner;

public class Insertion_Sort {
    public static void main(String[] args) {
//        System.out.println("Enter the size of n : ");
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        System.out.println("Enter all the elements of the array : ");
//        for(int i=0;i<n;i++){
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {5, 4, 3, 3, 2, 1};

        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int r = i;
            int l = i-1;
            while(l!=-1){
                if(arr[r]<arr[l]){
                    swap(arr,l,r);
                    l--;
                    r--;
                }
                else{
                    break;
                }
            }
        }
    }

    public static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}