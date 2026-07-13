package LeetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode1331 {

    public int[] arrayRankTransform(int[] arr) {

        if(arr.length==0) return arr;
        if(arr.length==1) return new int[]{1};

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }

}
