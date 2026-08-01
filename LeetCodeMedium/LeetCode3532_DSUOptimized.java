package LeetCodeMedium;

public class LeetCode3532_DSUOptimized {

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int[n];
        int compId = 0;

        for(int i=0;i<=n-2;i++){
            if(Math.abs(nums[i]-nums[i+1])<=maxDiff) component[i] = compId;
            else component[i] = compId++;
        }

        component[n-1] = compId++;

        boolean[] result = new boolean[queries.length];

        for(int i=0;i< queries.length;i++){
            result[i] = component[queries[i][0]]==component[queries[i][1]];
        }

        return result;
    }

}
