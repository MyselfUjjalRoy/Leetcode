class Solution {
    int n;
    int[][][] dp;
    public int solve(int idx , int buy , int k , int[] prices){
        if(k == 0) return 0;
        if(idx == n) return 0;

        if(dp[idx][buy][k] != -1){
            return dp[idx][buy][k];
        }

        if(buy == 1){
            return dp[idx][buy][k] = Math.max(-prices[idx] + solve(idx + 1 , 0 , k , prices) , 
            0 + solve(idx + 1 , 1 , k , prices));
        }
        else{
            return dp[idx][buy][k] = Math.max(prices[idx] + solve(idx + 1 , 1 , k - 1 , prices) , 
            0 + solve(idx + 1 , 0 , k , prices));
        }
    }
    public int maxProfit(int k, int[] prices) {
        n = prices.length;

        dp = new int[n][2][k + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return solve(0 , 1 , k , prices);
    }
}