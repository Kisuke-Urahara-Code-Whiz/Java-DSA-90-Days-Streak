package Programs;

import java.util.*;

class BubbleSort {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n =  sc.nextInt();
        int[] arr = new int[n];
        enterElements(arr, n);
        System.out.print("Original Array : [ ");
        display(arr,n);
        System.out.print(" ]\n");
        boolean flag = true;
        while(flag){
            flag = false;
            for(int j=0;j<(n-1);j++){
                if(arr[j]>arr[j+1]) {
                    int t = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = t;
                    flag=true;
                }
            }
        }
        System.out.print("Sorted Array : [ ");
        display(arr,n);
        System.out.print(" ]\n");
    }
    public static void display(int[] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            if(i!=(n-1)){
                System.out.print(", ");
            }
        }
    }
    public static void enterElements(int[] arr, int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.println("Enter element no. "+(i+1)+":");
            arr[i] = sc.nextInt();
        }
    }
}