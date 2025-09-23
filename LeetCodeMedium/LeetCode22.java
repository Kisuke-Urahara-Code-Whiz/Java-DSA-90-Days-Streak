package LeetCodeMedium;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        rec_gen(list, "", n, n, 0);
        return list;
    }

    public static void rec_gen(List<String> list, String s, int o, int e, int c){
        if(c==0 && o==0 && e==0) {
            list.add(s);
            return;
        }
        else if(c>0 && e<c)
            return;
        else{
            if(c==0 && o>0){
                rec_gen(list, s+"(", o-1, e, c+1);
            }
            else{
                if(o>0){
                    rec_gen(list, s+"(", o-1, e, c+1);
                }
                if(e>0){
                    rec_gen(list, s+")", o, e-1, c-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(5);
        System.out.println(list);
    }


}
