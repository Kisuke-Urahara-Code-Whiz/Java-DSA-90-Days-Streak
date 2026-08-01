package LeetCodeMedium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        sort(intervals, 0, intervals.length);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.push(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            if(mergePossible(deque.getLast(), intervals[i]))
                deque.addLast(mergeIntervals(deque.removeLast(), intervals[i]));
            else deque.addLast(intervals[i]);
        }

        int size = deque.size();
        int[][] result = new int[size][2];

        for(int i=0;i<size;i++){
            result[i] = deque.removeFirst();
        }

        return result;
    }

    public int[] mergeIntervals(int[] arr1, int[] arr2) {
        if(arr1[1]<=arr2[1]) return new int[]{arr1[0], arr2[1]};
        return new int[]{arr1[0], arr1[1]};
    }

    public boolean mergePossible(int[] arr1, int[] arr2){
        return arr1[1]>=arr2[0];
    }

    public void sort(int[][] arr, int l, int r){
        if(l>=r-1) return;
        int mid = l+(r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid, r);
        merge(arr, l, mid, r);
    }

    public void merge(int[][] arr, int l, int mid, int r){
        int l1 = mid - l;
        int l2 = r - mid;
        int[][] arr1 = new int[l1][2];
        int[][] arr2 = new int[l2][2];

        int index = l;
        for(int i=0;i<l1;i++){
            arr1[i] = arr[index++];
        }
        for(int i=0;i<l2;i++){
            arr2[i] = arr[index++];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while(i<l1 && j<l2){
            if(arr1[i][0]<arr2[j][0]) arr[k++] = arr1[i++];
            else arr[k++] = arr2[j++];
        }

        while(i<l1){
            arr[k++] = arr1[i++];
        }

        while(j<l2){
            arr[k++] = arr2[j++];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode56().merge(
                new int[][]{
                        {1,3},{2,6},{8,10},{15,18}
                }
        )));
    }

}
