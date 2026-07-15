package LeetCodeMedium;

import java.util.Arrays;

public class LeetCode3532 {

    int[] parent;
    int[] size;

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        parent = new int[n];
        size = new int[n];

        boolean[] result = new boolean[queries.length];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int i=0;i<nums.length-1;i++){
            if(Math.abs(nums[i]-nums[i+1])<=maxDiff) union(i, i+1);
        }

        for(int i=0;i< queries.length;i++){
            result[i] = find(queries[i][0])==find(queries[i][1]);
        }

        return result;
    }

    public int find(int n){
        if(parent[n]==n) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int a, int b){
        int parent1 = find(a);
        int parent2 = find(b);

        if(parent1 == parent2) return;

        if(size[parent1] < size[parent2]){
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        } else{
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode3532().pathExistenceQueries(
                4,
                new int[]{2,5,6,8},
                2,
                new int[][]{
                        {0,1},
                        {0,2},
                        {1,3},
                        {2,3}
                }
        )));
    }
}
