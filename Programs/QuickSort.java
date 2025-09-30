package Programs;

import java.util.Arrays;

public class QuickSort {

    public void quicksort(int[] arr, int p1, int p2){
        if(p2>p1){
            int pivot = arr[((p2-p1)+1)/2];
            int s = p1;
            int e = p2;
            while(s<e){
                if(arr[s]>=pivot && arr[e]<=pivot){
                    swap(arr,s,e);
                }
                if(arr[s]<pivot)
                    s+=1;
                if(arr[e]>pivot)
                    e-=1;
            }
            quicksort(arr,p1,e-1);
            quicksort(arr,s+1,p2);
        }
    }

    public void swap(int[] arr, int p1, int p2){
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,4,3,2,1};
        System.out.println("Original array -> \n"+ Arrays.toString(arr));
        QuickSort obj = new QuickSort();
        obj.quicksort(arr,0,arr.length-1);
        System.out.println("Sorted array -> \n"+Arrays.toString(arr));
    }

}
