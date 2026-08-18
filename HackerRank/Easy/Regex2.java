package HackerRank.Easy;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String regex = "\\d{5}\\s(C|CPP|JAVA|PYTHON|PERL|PHP|RUBY|CSHARP|HASKELL|CLOJURE|BASH|SCALA|ERLANG|CLISP|LUA|BRAINFUCK|JAVASCRIPT|GO|D|OCAML|R|PASCAL|SBCL|DART|GROOVY|OBJECTIVEC)";

        for(int i=1;i<=n;i++){
            String s = sc.nextLine();
            if(Pattern.matches(regex, s))
                System.out.println("VALID");
            else
                System.out.println("INVALID");
        }

        sc.close();
    }
}
