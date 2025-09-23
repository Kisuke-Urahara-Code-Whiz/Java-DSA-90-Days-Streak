package LeetCodeMedium;

public class LeetCode34 {

    //O(N)
    public int[] searchRange(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        int range [] =  new int[2];
        range[0]=lowerBound(nums,target);
        range[1]=upperBound(nums,target);
        return range;
    }


    //O(Log N)
    public int[] searchRangeLog(int[] nums, int target) {
        int range [] =  new int[2];
        range[0]=lowerBound(nums,target);
        range[1]=upperBound(nums,target);
        return range;
    }

    public static int lowerBound(int arr[],int target){
        int l=0;
        int r=arr.length-1;
        int lower = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            lower = arr[mid]==target?mid:lower;
            if(arr[mid]>=target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return lower;
    }

    public static int upperBound(int arr[],int target){
        int l=0;
        int r=arr.length-1;
        int upper = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            upper = arr[mid]==target?mid:upper;
            if(arr[mid]<=target){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return upper;
    }
}