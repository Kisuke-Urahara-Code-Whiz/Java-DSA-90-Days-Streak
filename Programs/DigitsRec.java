package Programs;

import java.util.Scanner;

public class DigitsRec {
    public int sum(int n){
        if(n!=0){
            return 1+sum(n/10);
        }
        else{
            return 0;
        }
    }

    public void numDigits(int n){
        if(n!=0){
            System.out.print(n%10+" ");
            numDigits(n/10);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        DigitsRec obj = new DigitsRec();
        int digits = obj.sum(n);
        System.out.println("Number of digits -> "+digits);
        if(digits!=0){
            System.out.println("Digits are -> ");
            obj.numDigits(n);
        }
    }

}
