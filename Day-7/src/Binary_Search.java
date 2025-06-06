import java.util.Arrays;
import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements of the array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter elements in sorted array : ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter the target element : ");
        int choice = sc.nextInt();
        int index = orderAgnosticSearch(arr,choice);
        if(index==-1)
            System.out.println("Target not found");
        else{
            System.out.println("Target found at index = "+index);
        }
    }

    public static int orderAgnosticSearch(int arr[],int target){
        int l = 0;
        int r = arr.length-1;
        boolean isAscending = arr[0]<arr[r];
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target)
                return mid;
            if(isAscending) {
                if(arr[mid]<target){
                    l = mid+1;
                }
                else{
                    r=mid-1;
                }
            }
            else{
                if(arr[mid]<target){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
            }
        }
        return -1;
    }
}