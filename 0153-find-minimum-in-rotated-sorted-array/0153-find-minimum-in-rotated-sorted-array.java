class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Minimum lies in the left half (including mid)
            if (nums[mid] < nums[high]) {
                high = mid;
            }
            // Minimum lies in the right half (excluding mid)
            else {
                low = mid + 1;
            }
        }

        // low and high have converged to the minimum element
        return nums[low];//or nums[high]
    }
}
