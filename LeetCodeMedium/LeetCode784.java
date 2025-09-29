package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode784 {

    public List<String> letterCasePermutation(String s) {
        List<String> arr = new ArrayList<>();
        char[] processed = new char[s.length()];
        backtrack(arr, s.toCharArray(), processed, 0);
        return arr;
    }

    public void backtrack(List<String> arr, char[] s, char[] processed, int p){
        if(p<s.length){
            char c = s[p];
            if(Character.isLetter(c)){
                processed[p] = Character.toUpperCase(c);
                backtrack(arr, s, processed, p+1);
                processed[p] = Character.toLowerCase(c);
                backtrack(arr, s, processed, p+1);
            }
            else {
                processed[p] = c;
                backtrack(arr, s, processed, p + 1);
            }
            processed[p] = ' ';
        }
        else
            arr.add(new String(processed));
    }

    public static void main(String[] args) {
        String s = "a1b2";
        LeetCode784 obj = new LeetCode784();
        System.out.println("String -> "+s);
        System.out.println("Letter Case Permutations -> ");
        System.out.println(obj.letterCasePermutation(s));
    }

}
