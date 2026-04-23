class Solution {
    int n;
    int[][][] dp;
    public int solve(int idx , int buy , int capacity , int[] prices){
        if(idx == n) return 0;
        if(capacity == 0) return 0;

        if(dp[idx][buy][capacity] != -1){
            return dp[idx][buy][capacity];
        }

        if(buy == 1){
            return dp[idx][buy][capacity] = Math.max(-prices[idx] + solve(idx + 1 , 0 , capacity , prices) , solve(idx + 1 , 1 , capacity , prices));
        }
        else{
            return dp[idx][buy][capacity] = Math.max(prices[idx] + solve(idx + 1 , 1 , capacity - 1 , prices) , solve(idx + 1 , 0 , capacity , prices));
        }
    }
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2][3];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return solve(0 , 1 , 2 , prices);
    }
}