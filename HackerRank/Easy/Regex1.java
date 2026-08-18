package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        scanner.nextLine();

        String regex = "^[Hh][Ii]\\s[^Dd].*";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String sentence = scanner.nextLine();

            Matcher matcher = pattern.matcher(sentence);
            if (matcher.matches()) {
                System.out.println(sentence);
            }
        }

        scanner.close();
    }
}

