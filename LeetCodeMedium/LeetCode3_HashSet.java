package LeetCodeMedium;

import java.util.HashSet;
import java.util.Set;

public class LeetCode3_HashSet {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int p1 = 0;
        int p2 = 0;
        int l = s.length();
        while(p2<l){
            char c = s.charAt(p2);
            if(!set.contains(c)){
                set.add(c);
                p2+=1;
            }
            else{
                while(s.charAt(p1)!=c){
                    set.remove(s.charAt(p1));
                    p1+=1;
                }
                p1+=1;
                p2+=1;
            }
            max = Math.max(max, p2-p1);
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        LeetCode3 obj = new LeetCode3();
        int max = obj.lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring -> "+max);
    }
}
