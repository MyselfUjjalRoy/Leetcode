class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDistance = 0;
        for(int i = 0; i < n - 1; i++){
            maxDistance = Math.max(maxDistance , Math.abs(nums[i] - nums[i + 1]));
        }
        maxDistance = Math.max(maxDistance , Math.abs(nums[0] - nums[n - 1]));
        return maxDistance;
    }
}