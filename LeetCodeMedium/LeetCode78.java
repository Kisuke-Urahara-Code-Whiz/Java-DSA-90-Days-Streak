package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        result.add(new ArrayList<>());
        dfs(0, temp, nums, result);
        return result;
    }

    public void dfs(int index, List<Integer> temp, int[] nums, List<List<Integer>> result){
        if(index==nums.length) return;
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(i+1, temp, nums, result);
            result.add(new ArrayList<>(temp));
            temp.removeLast();
        }
    }

}
