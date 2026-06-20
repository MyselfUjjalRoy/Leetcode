class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for(int i = 1; i < n + 1; i++){
            newNums[i] = nums[i - 1];
        }

        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(1 , n , newNums);
    }

    public int solve(int i , int j , int[] nums){
        if(i > j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;
        for(int idx = i; idx <= j; idx++){
            int coins = nums[i - 1] * nums[idx] * nums[j + 1] + solve(i , idx - 1 , nums) + solve(idx + 1 , j , nums);
            max = Math.max(max , coins);
        }

        return dp[i][j] = max;
    }
}