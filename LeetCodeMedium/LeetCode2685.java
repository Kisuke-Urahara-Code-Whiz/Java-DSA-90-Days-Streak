package LeetCodeMedium;

public class LeetCode2685 {

    int[] parent;
    int[] size;
    int[] edgesSize;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        edgesSize = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] i: edges){
            union(i);
        }

        int result = 0;

        for(int i=0;i<n;i++){
            if(parent[i]==i && edgesSize[i]==((size[i]*(size[i]-1))/2))
                result++;
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
                edgesSize[parent2]+=edgesSize[parent1]+1;
            } else {
                size[parent1]+=size2;
                parent[parent2] = parent1;
                edgesSize[parent1]+=edgesSize[parent2]+1;
            }
        } else edgesSize[parent1]++;
    }

}
