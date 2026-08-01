package LeetCodeMedium;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;

        int index = -1;
        for(int i=0;i< bank.length;i++){
            if(endGene.equals(bank[i])){
                index = i;
                break;
            }
        }
        if(index==-1) return -1;

        int mutations = 1;
        boolean[] visited = new boolean[bank.length];

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i< bank.length;i++){
            if(getDifference(bank[i], startGene) == 1) {
                if(i==index) return mutations;
                visited[i] = true;
                queue.add(i);
            }
        }
        int levelLength = queue.size();

        while(!queue.isEmpty()){
            while(levelLength!=0){
                int temp = queue.remove();
                for(int i=0;i< bank.length;i++){
                    if(!visited[i] && i!=temp && getDifference(bank[i], bank[temp])==1){
                        if(i==index) return ++mutations;
                        visited[i] = true;
                        queue.add(i);
                    }
                }
                levelLength--;
            }
            levelLength = queue.size();
            mutations++;
        }

        return -1;
    }

    public int getDifference(String s1, String s2){
        int diff = 0;
        for(int i=0;i<=7;i++){
            if(s1.charAt(i)!=s2.charAt(i)) diff++;
        }
        return diff;
    }

}
