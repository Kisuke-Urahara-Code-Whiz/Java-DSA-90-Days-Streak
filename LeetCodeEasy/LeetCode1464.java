package LeetCodeEasy;

public class LeetCode1464 {

    public int maxProduct(int[] nums) {
        int max = 0;
        int sMax = -1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]>=nums[max]){
                sMax = max;
                max = i;
            }
            else if(sMax==-1 || nums[i]>nums[sMax]) sMax = i;
        }

        return (nums[max]-1)*(nums[sMax]-1);
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1464().maxProduct(new int[]{10,2,5,2}));
    }
}
