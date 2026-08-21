package LeetCodeEasy;

import java.util.Arrays;

public class LeetCode338 {

    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int index = 1;
        int counter = 2;
        while(counter<=n){
            if(counter == (int)Math.pow(2, index)) index++;
            dp[counter] = dp[counter - (int)Math.pow(2,index-1)]+1;
            counter++;
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode338().countBits(5)));
    }

}
