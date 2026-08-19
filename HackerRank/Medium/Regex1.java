package HackerRank.Medium;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.nextLine();
        }

        Set<String> emails = new TreeSet<>();
        String regex = "[a-zA-z\\._0-9]+@[a-zA-z\\._0-9]+\\.[a-zA-z_0-9]+";
        Pattern pattern = Pattern.compile(regex);

        for(String s: str){
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()){
                emails.add(matcher.group());
            }
        }

        StringBuilder sb = new StringBuilder();

        for(String s: emails){
            sb.append(s);
            sb.append(";");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}
