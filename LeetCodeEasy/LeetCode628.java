package LeetCodeEasy;

import java.util.Arrays;

public class LeetCode628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int p1 = nums[0]*nums[1]*nums[nums.length-1];
        int p2 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];
        return Math.max(p1,p2);
    }

}
