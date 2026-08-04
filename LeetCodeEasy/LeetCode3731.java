package LeetCodeEasy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode3731 {

    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> result = new ArrayList<>();

        int index = 0;
        int sVal = nums[0];
        int eVal = nums[nums.length-1];

        for(int i=sVal;i<=eVal;i++){
            if(i==nums[index]) index++;
            else result.add(i);
        }

        return result;
    }

}
