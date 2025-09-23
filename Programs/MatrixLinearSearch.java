package Programs;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixLinearSearch  {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of rows in the matrix : ");
        int m =  sc.nextInt();
        System.out.println("Enter the number of columns in the matrix : ");
        int n =  sc.nextInt();
        int[][] arr = new int[m][n];
        enterElements(arr,sc,m,n);
        System.out.println("Original Matrix :");
        for(int i=0;i<m;i++)
            System.out.println(Arrays.toString(arr[i]));
        System.out.println("Enter the element to search : ");
        int search = sc.nextInt();
        LinearSearch(arr, search,m,n);
    }

    public static void enterElements(int[][] arr, Scanner sc,int m,int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                System.out.println("Enter ["+i+"]["+j+"] : ");
                arr[i][j] = sc.nextInt();
            }
        }
    }

    public static void LinearSearch(int[][] arr, int search,int m, int n) {
        int check = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(arr[i][j]==search){
                    System.out.println("Element exists in the matrix");
                    check=1;
                    break;
                }
                if(check==1)
                    break;
            }
        }
        if(check==0)
            System.out.println("-1. Element not found");
    }
}
