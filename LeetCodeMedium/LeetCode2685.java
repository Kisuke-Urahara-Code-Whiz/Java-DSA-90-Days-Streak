package LeetCodeMedium;

public class LeetCode2685 {

    int[] parent;
    int[] size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] i: edges){
            union(i);
        }
        int result = 0;
        for(int i=0;i<n;i++){
            if(i==parent[i]) result++;
        }
        return result;
    }

    public int find(int n){
        if(parent[n]==n) return n;
        return parent[n] = find(parent[n]);
    }

    public void union(int[] edge){
        int v1 = edge[0];
        int v2 = edge[1];

        int parent1 = find(v1);
        int parent2 = find(v2);

        if(parent1!=parent2){
            int size1 = size[parent1];
            int size2 = size[parent2];
            if(size1<size2){
                size[parent2]+=size1;
                parent[parent1] = parent2;
            } else {
                size[parent1]+=size2;
                parent[size2] = parent1;
            }
        }
    }

}
