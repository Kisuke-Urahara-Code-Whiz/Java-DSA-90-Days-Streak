package Programs;

import java.util.Scanner;

public class FactorialRec {
    public int factorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return n*factorial(n-1);
        }
    }

    public static void main(String[] args) {
        FactorialRec obj = new FactorialRec();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int p = obj.factorial(n);
        System.out.println("Factorial of "+n+" = "+p);
    }
}
