package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String[] string = new String[n];
        for(int i=0;i<n;i++){
            string[i] = sc.nextLine();
        }

        int testCases = sc.nextInt();
        sc.nextLine();
        String[] cases = new String[testCases];
        for(int i=0;i<testCases;i++){
            cases[i] = sc.nextLine();
        }

        for(String s: cases){
            int index = s.indexOf("our");
            String regex = "\\b"+s.substring(0,index)+"(our|or)"+s.substring(index+3)+"\\b";
            Pattern pattern = Pattern.compile(regex);
            int count = 0;
            for(String str: string){
                Matcher matcher = pattern.matcher(str);
                while(matcher.find()){
                    count+=1;
                }
            }
            System.out.println(count);
        }
    }
}
