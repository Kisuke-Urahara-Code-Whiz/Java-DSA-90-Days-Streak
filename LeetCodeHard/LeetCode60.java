package LeetCodeHard;

import java.util.HashMap;
import java.util.Map;

public class LeetCode60 {

    Map<Character, Boolean> map = new HashMap<>();
    int counter;
    boolean flag;

    public String getPermutation(int n, int k) {
        char[] nums = new char[n];
        for(int i=0;i<n;i++){
            nums[i] = (char)('0' + (i+1));
            map.put(nums[i],false);
        }
        String[] arr = new String[1];
        counter = k;
        flag = false;
        char[] processed = new char[n];
        backtrack(nums, 0, arr, processed);
        return arr[0];
    }

    public void backtrack(char[] nums, int p, String[] arr, char[] processed){
        if(p>=nums.length) {
            counter = counter-1;
            if(counter==0) {
                arr[0] = new String(processed);
                flag = true;
            }
        }
        else{
            for(int i=0;i<nums.length;i++){
                if(flag){
                    break;
                }
                else{
                    if(map.get(nums[i]))
                        continue;

                    map.put(nums[i],true);
                    processed[p] = nums[i];
                    backtrack(nums, p+1, arr,processed);
                    map.put(nums[i], false);
                    processed[p] = ' ';
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode60 obj = new LeetCode60();
        System.out.println(obj.getPermutation(3,1));
    }
}