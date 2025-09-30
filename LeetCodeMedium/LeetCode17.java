package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LeetCode17 {

    Map<Character, String> employeeMap = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length()==0)
            return res;
        else {
            char[] processed = new char[digits.length()];
            backtrack(res, processed, 0, digits);
            return res;
        }
    }

    public void backtrack(List<String> res, char[] processed, int p1, String digits){
        if(p1>=digits.length())
            res.add(new String(processed));
        else{
            String str = employeeMap.get(digits.charAt(p1));
            for(int i=0;i<str.length();i++){
                processed[p1] = str.charAt(i);
                backtrack(res, processed, p1+1, digits);
                processed[p1] = ' ';
            }
        }
    }

    public static void main(String[] args) {
        String s = "";
        LeetCode17 obj = new LeetCode17();
        System.out.println("The Number Called -> "+s);
        System.out.println("Letter Combinations ->\n"+obj.letterCombinations(s));
    }

}
