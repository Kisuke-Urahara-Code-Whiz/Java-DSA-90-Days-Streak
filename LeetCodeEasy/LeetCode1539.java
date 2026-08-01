package LeetCodeEasy;

public class LeetCode1539 {

    public int findKthPositive(int[] arr, int k) {
        int result = 0;
        int index = 0;
        int counter = 1;
        while(index<arr.length){
            if(k==0) return result;
            if(arr[index]==counter){
                index++;
            } else {
                k--;
                result = counter;
            }
            counter++;
        }
        while(k!=0){
            result = counter++;
            k--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode1539().findKthPositive(new int[]{2,3,4,7,11}, 5));
    }

}
