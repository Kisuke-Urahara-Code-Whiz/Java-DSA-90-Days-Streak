package LeetCodeMedium;

import java.util.*;

public class LeetCode207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[numCourses];

        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) queue.add(i);
        }

        int completed = 0;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            completed++;

            for(int next : graph.get(curr)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        return completed == numCourses;
    }

}
