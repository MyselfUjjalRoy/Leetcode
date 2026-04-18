class Solution {
    int[][] dp;
    public int solve(int i , int j , int[] nums){
        if(i > j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;

        for(int idx = i; idx <= j; idx++){
            int cost = nums[i - 1] * nums[idx] * nums[j + 1] + solve(i , idx - 1 , nums) + solve(idx + 1 , j , nums);

            ans = Math.max(ans , cost);
        }

        return dp[i][j] = ans;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;

        for(int i = 1;i <= n; i++){
            newNums[i] = nums[i - 1];
        }

        dp = new int[n + 2][n + 2];
        for(int i = 0; i < n + 2; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(1 , n  , newNums);
    }
}