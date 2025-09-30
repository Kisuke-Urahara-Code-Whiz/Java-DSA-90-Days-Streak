package Programs;

import java.util.Arrays;

public class BubbleSortRec {

    public void loop1(int[] arr, int n){
        if(n!=0){
            loop2(arr, 0, n);
            loop1(arr, n-1);
        }
    }

    public void loop2(int[] arr, int p1, int p2){
        if(p1!=p2){
            if(arr[p1]>arr[p1+1])
                swap(arr,p1,p1+1);
            loop2(arr,p1+1,p2);
        }
    }

    public void swap(int[] arr, int p1, int p2){
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};
        System.out.println("Original array -> \n"+ Arrays.toString(arr));
        BubbleSortRec obj = new BubbleSortRec();
        obj.loop1(arr,arr.length-1);
        System.out.println("Sorted array -> \n"+Arrays.toString(arr));
    }

}
