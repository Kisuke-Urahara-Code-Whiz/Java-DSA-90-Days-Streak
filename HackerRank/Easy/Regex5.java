package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }

        String preRegex = "(?<=\\w)(";
        String postRegex = ")(?=\\w)";

        int casesCount = sc.nextInt();
        sc.nextLine();
        String[] cases = new String[casesCount];

        for(int i=0;i<casesCount;i++){
            cases[i] = sc.nextLine();
        }

        for(String s: cases){
            Pattern pattern = Pattern.compile(preRegex+s+postRegex);
            int count = 0;
            for(String str: arr){
                Matcher matcher = pattern.matcher(str);
                while(matcher.find()){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
