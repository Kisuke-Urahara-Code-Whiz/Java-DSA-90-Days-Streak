import java.util.Arrays;
import java.util.Random;

public class Sorted_Check {
    public static void main(String[] args) {
        Random rand = new Random();
        int arr[] = new int[5];
        for(int i=1;i<= arr.length;i++){
            arr[i-1] = rand.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        boolean flag = check(arr,0);
        if(flag)
            System.out.println("Sorted");
        else
            System.out.println("Not Sorted");

    }

    public static boolean check(int arr[], int i){
        if (i== (arr.length-1))
            return true;
        else if (arr[i]>arr[i+1])
            return false;
        else
            return check(arr,i+1);
    }
}
