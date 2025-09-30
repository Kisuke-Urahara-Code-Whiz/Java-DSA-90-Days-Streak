package LeetCodeEasy;

public class LeetCode392 {

        public boolean isSubsequence(String s, String t) {
            if(s.isEmpty()){
                return true;
            }
            else{
                int p1 = 0;
                int p2 = 0;
                int l1 = t.length();
                int l2 = s.length();
                while(p2<l2 && p1<l1){
                    if(t.charAt(p1) == s.charAt(p2)){
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

}
