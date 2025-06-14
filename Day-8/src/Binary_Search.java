import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        System.out.println("Enter the size of n");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter all the elements of the array : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the elemnent to search : ");
        int search = sc.nextInt();
        boolean flag = search(arr,search);
        if(flag)
            System.out.println("Element found");
        else
            System.out.println("Element not found");
    }

    public static boolean search(int arr[], int search){
        boolean isAscending = arr[0]<arr[arr.length-1];
        int l = 0;
        int r = arr.length-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==search)
                return true;
            else if(isAscending){
                if(search>arr[mid])
                    l=mid+1;
                else
                    r=mid-1;
            }
            else{
                if(search>arr[mid])
                    r=mid-1;
                else
                    l=mid+1;
            }
        }
        return false;
    }
}
