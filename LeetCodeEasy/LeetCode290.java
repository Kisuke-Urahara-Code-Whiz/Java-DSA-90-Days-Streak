package LeetCodeEasy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LeetCode290 {

    public boolean wordPattern(String pattern, String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        if(pattern.length()!=words.size()) return false;

        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        int index = 0;

        while(index<pattern.length()){
             char i = pattern.charAt(index);
             String str = words.get(index);
             char tempChar = map2.getOrDefault(str, ' ');
             String tempStr = map1.getOrDefault(i, null);

             if(tempStr==null && tempChar==' '){
                 map1.put(i, str);
                 map2.put(str, i);
             } else if(tempStr==null || tempChar==' ') return false;
             else{
                 if(tempChar!=i || !tempStr.equals(str)) return false;
             }
             index++;
        }

        return true;
    }

    public boolean wordPattern1(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (map.containsKey(c) && !map.get(c).equals(w)) {
                return false;
            }
            map.put(c, w);
        }
        return new HashSet<>(map.values()).size() == map.size();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode290().wordPattern("abba","dog cat cat fish"));
    }

}
