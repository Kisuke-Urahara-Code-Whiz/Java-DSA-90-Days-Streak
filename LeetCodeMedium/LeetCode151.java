package LeetCodeMedium;

public class LeetCode151 {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        for(int i=0;i<words.length/2;i++){
            String temp = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = temp;
        }
        StringBuilder sb = new StringBuilder();
        for(String i: words){
            sb.append(i).append(" ");
        }
        return new String(sb).trim();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode151().reverseWords("  hello world  ".trim()));
    }


}
