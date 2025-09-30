package Programs;

import java.util.Scanner;

public class FibonacciRec {
    public void fibonacci( int a, int b, int n ){
        if(n!=0){
            System.out.print(a+b+" ");
            fibonacci(b,a+b,n-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter n -> ");
        int n = sc.nextInt();
        if(n!=0){
            System.out.println("Fibonacci Series -> ");
            if(n==1){
                System.out.print("0");
            }
            else if(n==2){
                System.out.print("0 1");
            }
            else{
                System.out.print("0 1 ");
                FibonacciRec obj = new FibonacciRec();
                obj.fibonacci(0,1,n-2);
            }
        }
    }
}
