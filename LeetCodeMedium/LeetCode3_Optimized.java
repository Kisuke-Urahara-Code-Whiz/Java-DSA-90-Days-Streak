package LeetCodeMedium;

public class LeetCode3_Optimized {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int i = 0;
            int j = 0;
            String ans = "";
            int len = 0;

            while (j < n) {
                char ch = s.charAt(j);

                if (ans.indexOf(ch) == -1) {
                    ans = s.substring(i, j + 1);
                } else {
                    while (s.charAt(i) != ch) {
                        i++;
                    }
                    i++;
                    ans = s.substring(i, j + 1);
                }

                len = Math.max(len, ans.length());
                j++;
            }

            return len;
        }
    }

    public static void main(String[] args) {
        String str = "pwwkew";
        Solution obj = new Solution();
        int max = obj.lengthOfLongestSubstring(str);
        System.out.println("Length of longest substring -> " + max);
    }
}
