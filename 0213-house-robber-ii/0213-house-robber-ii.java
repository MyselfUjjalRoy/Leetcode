class Solution {
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];
        
        dp = new int[n];
        Arrays.fill(dp , -1);

        int case1 = solve(0 , n - 1 , nums);
        
        Arrays.fill(dp , -1);

        int case2 = solve(1 , n , nums);

        return Math.max(case1 , case2);
    }

    public int solve(int idx , int n , int[] nums){
        if(idx >= n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int skip = solve(idx + 1 , n , nums);
        int steal = nums[idx] + solve(idx + 2 , n , nums);

        return dp[idx] = Math.max(skip , steal);
    }
}