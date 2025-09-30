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

    public int subsequenceCount(String s, String str){
        if(str.length()!=0){
            int p = 0;
            if(str.length()!=1) {
                p+=subsequenceCount(s + str.charAt(0), str.substring(1,str.length()));
                p+=subsequenceCount(s, str.substring(1,str.length()));
            }
            else{
                p+=subsequenceCount(s+str.charAt(0), "");
                p+=subsequenceCount(s, "");
            }
            return p;
        }
        else{
            return 1;
        }
    }

    public boolean issubsequence(String s, String t){
        if(t.isEmpty()){
            return true;
        }
        else{
            int p1 = 0;
            int p2 = 0;
            int l1 = s.length();
            int l2 = t.length();
            while(p2<l2 && p1<l1){
                if(s.charAt(p1) == t.charAt(p2)){
                    p2+=1;
                }
                p1+=1;
            }
            if(p2==l2)
                return true;
            else
                return false;
        }
    }

    public static void main(String[] args) {
        String a = "abc";
        String b = "abc";
        System.out.println("Original String -> "+a);
        StringSubsequence obj = new StringSubsequence();
        System.out.println("Subsequences -> ");
        obj.subsequence("",a);
        System.out.println(obj.stringList);
        System.out.println("Subsequnce Count -> "+ obj.subsequenceCount("",a));
        System.out.println("Non-Repeating Subsequences -> ");
        obj.repeatingSubsequence("",a);
        System.out.println(obj.strings);
        System.out.println("Non-Repeating Subsequences Count -> "+ obj.strings.size());
        System.out.println("Is "+b+" a subsequence of "+a+" -> "+ obj.issubsequence(a,b));
    }

}
