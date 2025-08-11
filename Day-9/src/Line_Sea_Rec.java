import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Line_Sea_Rec {
    public static void main(String[] args) {
        Random rand = new Random();
        int arr[] = new int[5];
        for(int i=1;i<= arr.length;i++){
            arr[i-1] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element to be checked : ");
        int n = sc.nextInt();

        boolean flag = check(arr,n,0);
        if(flag)
            System.out.println("Element Present");
        else
            System.out.println("Element Absent");

    }

    public static boolean check(int arr[],int ele,int index){
        if(arr.length-1 == index)
            return arr[index] == ele;
        return arr[index] == ele || check(arr,ele,index+1);
//        else{
//            if(arr[index] == ele)
//                return true;
//            else
//                return check(arr,ele,index+1);
//        }
    }
}
