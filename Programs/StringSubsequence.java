package Programs;

public class StringSubsequence {

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
            if(s.isEmpty()){
                System.out.println("NULL");
            }
            else{
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        String a = "abcde";
        System.out.println("Original String -> "+a);
        StringSubsequence obj = new StringSubsequence();
        System.out.println("Subsequences -> ");
        obj.subsequence("",a);
    }

}
