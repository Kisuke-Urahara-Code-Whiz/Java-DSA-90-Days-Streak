package LeetCodeMedium;

public class LeetCode633 {
    public boolean judgeSquareSum(int c) {
        long l = 0;
        long r = (long) Math.sqrt(c);
        while (l <= r) {
            long s = l * l + r * r;
            if (s == c) return true;
            if (s < c) l++;
            else r--;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Math.floor(1.75%10));
    }
}
