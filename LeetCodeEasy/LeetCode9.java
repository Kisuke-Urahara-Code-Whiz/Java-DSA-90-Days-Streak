package LeetCodeEasy;

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int p1 = 0;
        int p2 = s.length()-1;
        while(p1<=p2){
            if(s.charAt(p1) == s.charAt(p2)){
                p1++;
                p2--;
            }
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode9 obj = new LeetCode9();
        boolean flag = obj.isPalindrome(121);
        System.out.println(flag);
    }
}
