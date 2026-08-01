package LeetCodeEasy;

public class LeetCode3536 {

    public int maxProduct(int n) {
        int a = n%10;
        n = n/10;
        int b = n%10;
        n = n/10;

        int max = Math.max(a, b);
        int sMax = Math.min(a, b);

        while(n>0){
            int d = n%10;
            if(d>max) {
                sMax = max;
                max = d;
            } else if(d>sMax) sMax = d;
            n = n/10;
        }

        return max*sMax;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3536().maxProduct(724));
    }


}
