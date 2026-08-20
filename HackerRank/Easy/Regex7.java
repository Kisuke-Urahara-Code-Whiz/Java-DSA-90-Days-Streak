package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex7 {

    public static void main(String[] args) {

        String regex1 = "^\\w*?hackerrank\\w*?$";
        String regex2 = "^hackerrank";
        String regex3 = "hackerrank$";

        Pattern pattern1 = Pattern.compile(regex1);
        Pattern pattern2 = Pattern.compile(regex2);
        Pattern pattern3 = Pattern.compile(regex3);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextLine();
        }

        for(String s: arr){
            if(pattern1.matcher(s).find()) System.out.println(0);
            else if(pattern2.matcher(s).find()) System.out.println(1);
            else if(pattern3.matcher(s).find()) System.out.println(2);
            else System.out.println(-1);
        }
    }
}
