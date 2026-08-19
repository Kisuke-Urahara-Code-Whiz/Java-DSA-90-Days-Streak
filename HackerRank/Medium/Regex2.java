package HackerRank.Medium;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] str = new String[n];
        for(int i=0;i<n;i++){
            str[i] = sc.nextLine();
        }

        Set<String> emails = new TreeSet<>();
        String regex = "(?:https?:\\/\\/)(?:www\\.|ww2\\.)?([a-zA-Z0-9_.-]+\\.[a-zA-Z0-9]+)";
        Pattern pattern = Pattern.compile(regex);

        for(String s: str){
            Matcher matcher = pattern.matcher(s);
            while(matcher.find()){
                emails.add(matcher.group(1));
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
