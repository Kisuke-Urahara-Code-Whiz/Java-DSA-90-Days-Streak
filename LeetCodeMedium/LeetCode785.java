package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode785 {

    public boolean isBipartite(int[][] graph){
        int[] nodes = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (nodes[i] == 0) {
                nodes[i] = 1;
                queue.add(i);

                while (!queue.isEmpty()) {
                    int node = queue.remove();
                    int color = nodes[node] == 1 ? 2 : 1;
                    for (int nei : graph[node]) {
                        if (nodes[nei] == 0) {
                            nodes[nei] = color;
                            queue.add(nei);
                        } else if (nodes[nei] != color) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }

}
