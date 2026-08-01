package LeetCodeMedium;

public class LeetCode1334 {

    private static final int INF = Integer.MAX_VALUE;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++) {
                if(i==j) continue;
                dp[i][j] = INF;
            }
        }

        for(int[] i: edges){
            dp[i[0]][i[1]] = i[2];
            dp[i[1]][i[0]] = i[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][k]!=INF && dp[k][j]!=INF){
                        int actualDistance = dp[i][j];
                        int tempDistance = dp[i][k] + dp[k][j];
                        if(tempDistance<actualDistance) dp[i][j] = tempDistance;
                    }
                }
            }
        }

        int[] reachable = new int[n];

        int result = INF;

        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++) {
                if(i!=j && dp[i][j]<=distanceThreshold) reachable[i] += 1;
            }
            result = Math.min(result, reachable[i]);
        }

        for(int i=n-1;i>=0;i--){
            if(reachable[i]==result) return i;
        }

        return -1;
    }

}
