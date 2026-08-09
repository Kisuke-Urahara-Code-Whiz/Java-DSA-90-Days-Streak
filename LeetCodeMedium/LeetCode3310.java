package LeetCodeMedium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode3310 {

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }

        for(int[] i: invocations){
            graph.get(i[0]).add(i[1]);
        }

        boolean[] visited = new boolean[n];
        boolean[] buggy = new boolean[n];

        buggy[k] = true;
        dfs(k, visited, buggy, graph, true);

        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean flag = dfs(i, visited, buggy, graph, false);
                if(flag){
                    for(int j=0;j<n;j++){
                        result.add(j);
                    }
                    return result;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!buggy[i]) result.add(i);
        }

        return result;
    }

    boolean dfs(int node, boolean[] visited, boolean[] buggy, HashMap<Integer, List<Integer>> graph, boolean parentBug){
        if(visited[node] && buggy[node] && !parentBug) return true;
        else if(visited[node]) return false;
        else{
            visited[node] = true;
            buggy[node] = parentBug;
            List<Integer> path = graph.get(node);
            int length = path.size();

            for (Integer integer : path) {
                boolean flag = dfs(integer, visited, buggy, graph, parentBug);
                if (flag) return true;
            }

            return false;
        }
    }

}
