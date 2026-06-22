class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        
        if(n == 1) return 0;
        else if(nums[0] > nums[1]) return 0;
        else if(nums[n - 1] > nums[n - 2]) return n - 1;

        int low = 1;
        int high = n - 2;

        int ans = 0;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]){
                return mid;
            }
            else if(nums[mid] < nums[mid + 1]){ // means increasing slope
                low = mid + 1;
            }
            else{ // means decreasing slope
                high = mid - 1;
            }
        }

        return -1; // unreachable
    }
}