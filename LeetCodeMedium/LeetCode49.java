package LeetCodeMedium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode49 {

    boolean isAnagram(String s1, String s2){
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        for(int i: arr){
            if(i!=0) return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] go = new boolean[strs.length];
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<strs.length; i++){
            if(!go[i]) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(strs[i].length()==strs[j].length() && isAnagram(strs[i], strs[j])){
                        temp.add(strs[j]);
                        go[j] = true;
                    }
                }
                result.add(temp);
            }
        }
        return result;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
