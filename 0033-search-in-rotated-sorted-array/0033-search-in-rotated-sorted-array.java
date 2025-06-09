class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[low] <= nums[mid]){//to avoid the case [3,3] where elements are equal but if we do only < then some cases will be left
                if(nums[low] <= target && target < nums[mid]){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{
                if(target > nums[mid] && target <= nums[high]){
                    low = mid + 1;
                }
                else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}