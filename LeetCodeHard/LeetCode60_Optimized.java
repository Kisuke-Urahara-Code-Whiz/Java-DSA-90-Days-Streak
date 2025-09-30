package LeetCodeHard;

import java.util.*;

class LeetCode60_Optimized {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
            numbers.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int idx = k / fact[i - 1];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= fact[i - 1];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode60_Optimized sol = new LeetCode60_Optimized();
        System.out.println(sol.getPermutation(3, 3));
        System.out.println(sol.getPermutation(4, 9));
    }
}

