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
        System.out.println("Enter the target element : ");
        int choice = sc.nextInt();
        int index = orderAgnosticSearch(arr,choice);
        if(index==-1)
            System.out.println("Target not found");
        else{
            System.out.println("Target found at index = "+index);
        }
    }

    public static int orderAgnosticSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        boolean isAscending = arr[left] < arr[right];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAscending) {
                if (target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1; 
    }
}