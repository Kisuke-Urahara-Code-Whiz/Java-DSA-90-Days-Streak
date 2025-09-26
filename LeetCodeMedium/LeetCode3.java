package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        String a = "";
        int max = 0;
        int p1 = 0;
        int p2 = 0 ;
        int len = a.length();
        int og_len = s.length();
        while(p2<og_len){
            char c = s.charAt(p2);
            if(a.indexOf(c)==-1){
                a = a+c;
            }
            else{
                int index = a.indexOf(c);
                p1 = index+1;
                len = len - p1;
                a = a.substring(index+1) + c;
            }
            len+=1;
            p2+=1;
            if(len>max)
                max = len;
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
