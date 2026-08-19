package HackerRank;

public class RegexTester {

    public static void main(String[] args) {
        String s = "favourite";
        int index = s.indexOf("our");
        String regex = s.substring(0,index)+"(our|or)"+s.substring(index+3);
        System.out.println(regex);
    }
}
