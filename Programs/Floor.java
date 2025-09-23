package Programs;

import java.util.Arrays;
import java.util.Scanner;

public class Floor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the numbers of the array : ");
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        System.out.println("Enter the element : ");
        int ele = sc.nextInt();
        int floor = find(arr,ele);
        System.out.println("The floor element of the number "+ele+" is "+floor);
    }

    public static int find(int arr[],int ele){
        int l=0;
        int r = arr.length-1;
        int floor = -1;
        while(l<=r) {
            int mid = l+(r-l)/2;
            if(arr[mid]==ele || arr[mid]==floor)
                return arr[mid];
            else if(arr[mid]<ele){
                floor = arr[mid];
                l=mid+1;
            }
            else {
                r = mid - 1;
            }
        }
        return floor;
    }
}
