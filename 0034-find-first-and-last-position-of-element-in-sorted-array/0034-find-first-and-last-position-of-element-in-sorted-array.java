class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {findFirst(nums , target) , findLast(nums , target)};
        return ans;
    }
    public int findFirst(int[] nums , int target){
        int low = 0, high = nums.length - 1;
        int firstPosition = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                firstPosition = mid;
                high = mid -1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }            
        }
        return firstPosition;
    }

     public int findLast(int[] nums , int target){
        int low = 0, high = nums.length - 1;
        int lastPosition = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                lastPosition = mid;
                low = mid + 1;
            }
            else if(nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }            
        }
        return lastPosition;
    }
}