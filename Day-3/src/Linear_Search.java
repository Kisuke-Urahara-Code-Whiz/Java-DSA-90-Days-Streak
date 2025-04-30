import java.util.*;

class Linear_Search {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("Enter the number of elements in the array : ");
        int n =  sc.nextInt();
        int[] arr = new int[n];
        enterElements(arr, n);
        System.out.println("Original Array :");
        System.out.println(Arrays.toString(arr));
        if(arr.length==0)
            System.out.println("Null Array");
        else {
            System.out.println("Enter the element to search : ");
            int search = sc.nextInt();
            LinearSearch(arr, search);
        }
    }

    public static void enterElements(int[] arr, int n){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<n;i++){
            System.out.println("Enter element no. "+(i+1)+":");
            arr[i] = sc.nextInt();
        }
    }

    public static void LinearSearch(int[] arr, int search) {
        int length = 0;
        for(int i:arr){
            if(i==search) {
                System.out.println("Element exists in the array");
                break;
            }
            length++;
        }
        if(length==arr.length)
            System.out.println("-1. Element not found");
    }
}