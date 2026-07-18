package LeetCodeEasy;

public class LeetCode1979 {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        return gcd(max,min);
    }

    public int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
