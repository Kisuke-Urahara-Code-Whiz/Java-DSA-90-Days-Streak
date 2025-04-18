import java.util.Scanner;

public class Occurences {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter a number : ");
        int n = sc.nextInt();
        System.out.println("Find the number to search : ");
        int c = sc.nextInt();
        int occ = 0;
        while(n>0){
            int d = n%10;
            if(d==c)
                occ++;
            n/=10;
        }
        if(occ!=0){
            System.out.println(c+" has "+occ+" occurences");
        }
        else{
            System.out.println(c+" has no occurences");
        }
    }
}
