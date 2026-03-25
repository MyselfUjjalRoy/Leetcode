class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n + 1];
        dp[0] = 0;

        for(int i = 1; i <= n; i++){
            int steal = nums[i - 1] + (i >= 2 ? dp[i - 2] : 0);
            int skip = dp[i - 1];

            dp[i] = Math.max(steal , skip);
        }

        return dp[n];
    }
}