package LeetCodeMedium;

import java.util.ArrayList;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        String a = "";
        int max = 0;
        int p1 = 0;
        int p2 = 0 ;
        while(p2<s.length()){
            char c = s.charAt(p2);
            if(!arr.contains(c)){
                a = a+c;
                arr.add(c);
            }
            else{
                int index = a.indexOf(c);
                p1 = index+1;
                a = a.substring(index+1) + c;
                arr = new ArrayList<>(arr.subList(p1, arr.size()));
                arr.add(c);
            }
            if(a.length()>max)
                max = a.length();
            p2+=1;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        LeetCode3 obj = new LeetCode3();
        int max = obj.lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring -> "+max);
    }
}
