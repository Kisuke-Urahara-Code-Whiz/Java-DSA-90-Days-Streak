import java.util.Scanner;

public class Selection_Sort {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n =  sc.nextInt();
        int[] arr = new int[n];
        enterElements(arr, n, sc);
        System.out.print("Original Array : [ ");
        display(arr,n);
        System.out.print(" ]\n");
        sort(arr,n);
        System.out.print("Sorted Array : [ ");
        display(arr,n);
        System.out.print(" ]\n");
        sc.close();
    }

    public static void sort(int[] arr,int n){
        for(int i=0;i<(n-1);i++){
            int min = i;
            for(int j=(i+1);j<n;j++){
                if(arr[min]>arr[j]){
                    min = j;
                }
            }
            if(min!=i) {
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void display(int[] arr, int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]);
            if(i!=(n-1)){
                System.out.print(", ");
            }
        }
    }
    public static void enterElements(int[] arr, int n, Scanner sc){
        for(int i=0;i<n;i++){
            System.out.println("Enter element no. "+(i+1)+":");
            arr[i] = sc.nextInt();
        }
    }


}
