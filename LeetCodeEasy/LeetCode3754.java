package LeetCodeEasy;

public class LeetCode3754 {

    public long sumAndMultiply(int n) {
        int extracted = 0;
        int pow = 0;
        int sum = 0;
        while(n>0){
            int d = n%10;
            if(d!=0){
                extracted+=(int)Math.pow(10,pow++)*d;
                sum+=d;
            }
            n/=10;
        }

        return (long) extracted *sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode3754().sumAndMultiply(10203004) );
    }

}
