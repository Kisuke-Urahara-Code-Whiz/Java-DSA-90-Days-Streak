package LeetCodeEasy;

//OFS
public class LeetCode3014 {

    public int minimumPushes(String word) {
        int n = word.length();
        int blocks = n / 8;
        return (blocks * (blocks + 1) * 4)
                + (n % 8) * (blocks + 1);
    }

}
