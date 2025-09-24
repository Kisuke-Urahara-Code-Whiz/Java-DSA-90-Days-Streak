package LeetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LeetCode15_Brute {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        String str = "";
        if(nums.length >= 3){
            for(int i=0;i<nums.length-2;i++){
                for(int j=i+1;j<nums.length-1;j++){
                    for(int k=j+1;k<nums.length;k++){
                        if(nums[i]+nums[j]+nums[k] == 0){
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            Collections.sort(temp);
                            boolean flag = false;
                            for(int c=0; c<res.size();c++){
                                if(temp.equals(res.get(c))){
                                    flag = true;
                                    break;
                                }
                            }
                            if(!flag){
                                res.add(temp);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        LeetCode15_Brute obj = new LeetCode15_Brute();
        List<List<Integer>> res = obj.threeSum(arr);
        for(int i = 0; i<res.size(); i++){
            System.out.println(Arrays.toString(res.get(i).toArray()));
        }
    }

}
