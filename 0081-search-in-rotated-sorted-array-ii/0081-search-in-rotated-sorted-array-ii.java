// class Solution {
//     public boolean search(int[] nums, int target) {
        
//     }
// }
class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // target found
            if (nums[mid] == target) return true;

            // because we can't decide which part is sorted
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }


            // LEFT half is sorted
            if (nums[low] <= nums[mid]) {

                // check if target lies in the sorted left half
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1; // search left side
                } 
                else {
                    low = mid + 1; // search right side
                }
            }

            // RIGHT half is sorted
            else {

                // check if target lies in the sorted right half
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1; // search right side
                } 
                else {
                    high = mid - 1; // search left side
                }
            }
        }

        // target not found
        return false;
    }
}