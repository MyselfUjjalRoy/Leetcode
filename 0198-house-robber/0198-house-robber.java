class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp , -1);

        return solve(0 , n , nums);
    }
    public int solve(int idx , int n , int[] nums){
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int steal = nums[idx] + solve(idx + 2 , n , nums);
        int skip = solve(idx + 1 , n , nums);

        return dp[idx] = Math.max(steal , skip);
    }
}