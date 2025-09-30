package Programs;

public class StringPermutations {

    public void permutations(String processed, String unprocessed){
        if(unprocessed.isEmpty())
            System.out.println(processed);
        else{
            for(int i=0;i<unprocessed.length();i++){
                permutations(processed+unprocessed.charAt(i), unprocessed.substring(0,i)+unprocessed.substring(i+1));
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        StringPermutations obj = new StringPermutations();
        System.out.println("Original String -> "+s);;
        System.out.println("Permutations -> ");
        obj.permutations("", s);
    }
}
