package LeetCodeEasy;

import java.util.*;

public class LeetCode2273 {

    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        char[] c = words[0].toCharArray();
        Arrays.sort(c);
        String previous = new String(c);
        for(int i=1;i< words.length;i++){
            char[] temp = words[i].toCharArray();
            Arrays.sort(temp);
            String current = new String(temp);
            if(!current.equals(previous)){
                previous = current;
                result.add(words[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode2273().removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));
    }

}
