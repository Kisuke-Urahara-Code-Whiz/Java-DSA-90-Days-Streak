package LeetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode40 {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, candidates, temp, target);
        return result;
    }

    public void dfs(int index, int[] candidates, List<Integer> temp, int remainingSum){
        if(remainingSum==0) result.add(new ArrayList<>(temp));
        else {
            int prev = -1;
            for (int i = index; i < candidates.length; i++) {
                if (prev != candidates[i]) {
                    prev = candidates[i];
                    if (remainingSum - prev >= 0) {
                        temp.add(prev);
                        dfs(i + 1, candidates, temp, remainingSum - prev);
                        temp.removeLast();
                    }
                }
            }
        }
    }

}
