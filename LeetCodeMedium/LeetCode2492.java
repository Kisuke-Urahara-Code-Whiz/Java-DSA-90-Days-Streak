package LeetCodeMedium;

public class LeetCode2492 {

//    Idea -> There are disconnected components.
//    There is always a path from 1 to n
//    U can traverse back and forth the same vertex in the same path.
//    Thus, there is always a path that covers all edge in a connected component. (Valid path from 1 to n)
//    We just need to find the most minimum edge in the connected component of 1 to n.


    int[] parent;
    int[] size;
    int[] min;

    int find(int node){
        if(parent[node]==node) return node;
        return parent[node] = find(parent[node]);
    }

    void merge(int[] edge){
        int v1 = edge[0];
        int v2 = edge[1];

        int parent1 = find(v1);
        int parent2 = find(v2);

        if(parent1!=parent2){
            int size1 = size[parent1];
            int size2 = size[parent2];

            if(size1>size2){
                size[parent1]+=size2;
                parent[parent2] = parent1;
                min[parent1] = Math.min(min[parent1], min[parent2]);
                min[parent1] = Math.min(min[parent1], edge[2]);
            } else {
                size[parent2]+=size1;
                parent[parent1] = parent2;
                min[parent2] = Math.min(min[parent1], min[parent2]);
                min[parent2] = Math.min(min[parent2], edge[2]);
            }
        } else min[parent1] = Math.min(min[parent1], edge[2]);
    }

    public int minScore(int n, int[][] roads) {
        parent = new int[n+1];
        size = new int[n+1];
        min = new int[n+1];

        for(int i = 1; i<=n ; i++){
            parent[i] = i;
            size[i] = 1;
            min[i] = Integer.MAX_VALUE;
        }

        for(int[] i: roads){
            merge(i);
        }

        int parent = find(1);
        return min[parent];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2492().minScore(4,
                new int[][]{
                        {1,2,9},
                        {2,3,6},
                        {2,4,5},
                        {1,4,7}
                }));
    }

}
