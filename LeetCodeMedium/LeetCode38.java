package LeetCodeMedium;

public class LeetCode38 {

    public String countAndSay(int n) {
        String res = "1";
        for(int i = 2; i<=n; i++){
            StringBuilder sb = new StringBuilder();
            String temp = res;
            int count = 1;
            int p = 1;
            char  ch = res.charAt(0);
            while(p<=temp.length()){
                if(p==res.length()){
                    sb.append(count);
                    sb.append(ch);
                    res = new String(sb);
                    p+=1;
                } else if(res.charAt(p)!=ch){
                    sb.append(count);
                    sb.append(ch);
                    count = 1;
                    ch = res.charAt(p);
                    p+=1;
                } else {
                    count+=1;
                    p+=1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        LeetCode38 obj = new LeetCode38();
        System.out.println("Count and Say -> "+obj.countAndSay(n));
    }

}

//public String countAndSay(int n) {
//    String res = "1";
//    for (int i = 1; i < n; i++) {
//        res = buildNext(res);
//    }
//    return res;
//}
//
//private String buildNext(String s) {
//    StringBuilder sb = new StringBuilder(s.length() * 2); // pre-size
//    char prev = s.charAt(0);
//    int count = 1;
//
//    for (int i = 1; i < s.length(); i++) {
//        char c = s.charAt(i);
//        if (c == prev) {
//            count++;
//        } else {
//            sb.append(count).append(prev);
//            prev = c;
//            count = 1;
//        }
//    }
//    sb.append(count).append(prev);
//    return sb.toString();
//}

