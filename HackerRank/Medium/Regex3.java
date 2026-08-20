package HackerRank.Medium;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex3 {

    public static void main(String[] args) {
        String preRegex = "\\b";
        String postRegex = "\\b";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }

        int caseCount = sc.nextInt();
        sc.nextLine();
        String[] cases = new String[caseCount];
        for(int i=0;i<caseCount;i++){
            Pattern pattern = Pattern.compile(preRegex+sc.nextLine()+postRegex);
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
