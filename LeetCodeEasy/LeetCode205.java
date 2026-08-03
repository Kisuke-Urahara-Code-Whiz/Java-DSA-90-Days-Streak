package LeetCodeEasy;

import java.util.HashMap;

public class LeetCode205 {

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for(int i=0;i<s.length();i++){
            Character c1 = map1.getOrDefault(s.charAt(i), null);
            Character c2 = map2.getOrDefault(t.charAt(i), null);
            if(c1==null && c2==null){
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            } else if(c1==null || c2==null) return false;
            else if(c1!=t.charAt(i) || c2!=s.charAt(i)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode205().isIsomorphic("abab","baba"));
    }

}