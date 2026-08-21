package LeetCodeEasy;

public class LeetCode746 {

    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        int[] dp = new int[cost.length];
        dp[cost.length-1] = cost[cost.length-1];
        dp[cost.length-2] = cost[cost.length-2];

        for(int i=cost.length-3;i>=0;i--){
            dp[i] = Math.min(cost[i]+dp[i+1], cost[i]+dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

}
