package Programs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StringSubsequence {

    Set<String> strings;
    ArrayList<String> stringList;


    StringSubsequence(){
        strings = new HashSet<>();
        stringList = new ArrayList<>();
    }

    public void subsequence(String s, String str){
        if(str.length()!=0){
            if(str.length()!=1) {
                subsequence(s + str.charAt(0), str.substring(1,str.length()));
                subsequence(s, str.substring(1,str.length()));
            }
            else{
                subsequence(s+str.charAt(0), "");
                subsequence(s, "");
            }
        }
        else{
            stringList.add(s);
        }
    }

    public void repeatingSubsequence(String s, String str){
        if(str.length()!=0){
            if(str.length()!=1) {
                repeatingSubsequence(s + str.charAt(0), str.substring(1,str.length()));
                repeatingSubsequence(s, str.substring(1,str.length()));
            }
            else{
                repeatingSubsequence(s+str.charAt(0), "");
                repeatingSubsequence(s, "");
            }
        }
        else{
            if(!strings.contains(s)){
                strings.add(s);
            }
        }
    }

    public static void main(String[] args) {
        String a = "aab";
        System.out.println("Original String -> "+a);
        StringSubsequence obj = new StringSubsequence();
        System.out.println("Subsequences -> ");
        obj.subsequence("",a);
        System.out.println(obj.stringList);
        System.out.println("Non-Repeating Subsequences -> ");
        obj.repeatingSubsequence("",a);
        System.out.println(obj.strings);
    }

}
