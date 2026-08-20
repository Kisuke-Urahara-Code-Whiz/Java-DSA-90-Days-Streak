package HackerRank.Easy;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex8 {

    public static void main(String[] args) {
        String regex = "(?<=<)(?<!\\/)(\\w+)";
        Pattern pattern = Pattern.compile(regex);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Set<String> set = new TreeSet<>();

        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] = sc.nextLine();
        }

        for(String str: s){
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()){
                set.add(matcher.group(1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String str: set){
            sb.append(str);
            sb.append(";");
        }

        System.out.println(sb.substring(0,sb.length()-1));
    }
}
