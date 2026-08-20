package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex6 {

    public static void main(String[] args) {
        String regex = "^(_|\\.)\\d+[a-zA-Z]*_?";
        Pattern pattern = Pattern.compile(regex);

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] s = new String[n];
        for(int i=0;i<n;i++){
            s[i] = sc.nextLine();
        }

        for(String str: s){
            if(pattern.matcher(str).matches()) System.out.println("VALID");
            else System.out.println("INVALID");
        }

    }
}
