package Programs;

import java.util.Scanner;

public class StringLinearSearch {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the word : ");
        String str =  sc.next();
        System.out.println("Original String :");
        System.out.println(str);
        if(str.isEmpty())
            System.out.println("No Word Entered");
        else {
            System.out.println("Enter the letter to search in lowercase : ");
            char search = sc.next().charAt(0);
            LinearSearch(str, search);
        }
    }

    public static void LinearSearch(String str, char search) {
        int length = 0;
        for(char i:str.toLowerCase().toCharArray()){
            if(i==search) {
                System.out.println("Letter exists in the word");
                break;
            }
            length++;
        }
        if(length==str.length())
            System.out.println("-1. Letter not found");
    }
}
