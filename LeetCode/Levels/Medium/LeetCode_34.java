//LEETCODE MEDIUM
//34. Find Last and First Position of Element in Sorted Array
//
//Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
//
//If target is not found in the array, return [-1, -1].
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
//Example 2:
//
//Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
//Example 3:
//
//Input: nums = [], target = 0
//Output: [-1,-1]
//
//
//Constraints:
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//nums is a non-decreasing array.
//        -109 <= target <= 109

public class LeetCode_34 {

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
