class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        int[] dp = new int[n];
        // dp[i]=Maximum amount of money the robber can steal from the first i+1 houses.

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            int steal = nums[i] + dp[i - 2];
            int skip = dp[i - 1];
            dp[i] = Math.max(steal, skip);
        }

        return dp[n - 1];
    }
}