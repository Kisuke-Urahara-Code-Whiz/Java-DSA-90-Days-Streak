package LeetCodeHard;

public class LeetCode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length+ nums2.length];
        int sums = 0;
        double median = 0;
        int m = 0;
        int n = 0;
        for(int i=0;i<arr.length;i++) {
            if (m < nums1.length && n < nums2.length) {
                if (nums1[m] < nums2[n]) {
                    arr[i] = nums1[m];
                    sums += arr[i];
                    m += 1;
                } else {
                    arr[i] = nums2[n];
                    sums += arr[i];
                    n += 1;
                }
            } else {
                if (m >= nums1.length) {
                    arr[i] = nums2[n];
                    sums += arr[i];
                    n += 1;
                } else {
                    arr[i] = nums1[m];
                    sums += arr[i];
                    m += 1;
                }
            }
        }
        if(arr.length%2!=0){
            median = arr[arr.length/2];
        }
        else{
            median = (double)(arr[(arr.length/2)-1] + arr[arr.length/2])/2;
        }
        return median;
    }

    public static void main(String[] args) {
        LeetCode4 solution = new LeetCode4();

        int[] array1 = {1, 3};
        int[] array2 = {2};

        double median = solution.findMedianSortedArrays(array1, array2);

        System.out.println("The median is: " + median);
    }
}
