package LeetCodeEasy;

import java.util.HashMap;

public class LeetCode242 {

    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c,0)-1);
        }
        for(int c: map.values()){
            if(c!=0) return false;
        }
        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int count:freq){
            if(count!=0){
                return false;
            }
        }
        return true;
    }


}
