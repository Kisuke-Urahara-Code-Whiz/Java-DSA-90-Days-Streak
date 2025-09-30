package Programs;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] arr){
        int len = arr.length;
        if(len!=1) {
            int mid = len / 2;
            int[] arr1 = new int[mid];
            int[] arr2 = new int[len - mid];
            for (int i = 0; i < mid; i++)
                arr1[i] = arr[i];
            for (int i = 0; i < (len - mid); i++)
                arr2[i] = arr[mid + i];
            sort(arr1);
            sort(arr2);
            merge(arr1, arr2, arr);
        }
    }

    public void merge(int[] left, int[] right, int[] arr){
        int i = 0;
        int j = 0;
        int l1 = left.length;
        int l2 = right.length;
        int l = arr.length;
        int k = 0;

        while(i<l1 && j<l2){
            if(left[i]<right[j]) {
                arr[k] = left[i];
                k+=1;
                i+=1;
            }
            else{
                arr[k] = right[j];
                k+=1;
                j+=1;
            }
        }

        while(i<l1){
            arr[k] = left[i];
            k+=1;
            i+=1;
        }

        while(j<l2){
            arr[k] = right[j];
            k+=1;
            j+=1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{100,34,45,23,14,54,1};
        System.out.println("Original array -> \n"+ Arrays.toString(arr));
        MergeSort obj = new MergeSort();
        obj.sort(arr);
        System.out.println("Sorted array -> \n"+Arrays.toString(arr));
    }

}
