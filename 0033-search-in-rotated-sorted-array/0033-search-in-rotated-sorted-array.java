class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) return mid;

            if(nums[low] <= nums[mid]){ // means left side sorted
                if(nums[low] <= target && target < nums[mid]){ // mid already checked
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            else{ // right part sorted
                if(nums[mid] < target && target <= nums[high]){ // mid already checked
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