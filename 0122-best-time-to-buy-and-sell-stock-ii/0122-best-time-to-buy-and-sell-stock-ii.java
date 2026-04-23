class Solution {
    int n;
    int[][] dp;
    public int solve(int idx , int buy , int[] prices){
        if(idx == n){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        if(buy == 1){
            return dp[idx][buy] = Math.max(-prices[idx] + solve(idx + 1 , 0 , prices) , solve(idx + 1 , 1 , prices));
        }
        else{
            return dp[idx][buy] = Math.max(prices[idx] + solve(idx + 1 , 1 , prices) , solve(idx + 1 , 0 , prices));
        }
    }
    public int maxProfit(int[] prices) {
        n = prices.length;

        dp = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 1 , prices);
    }
}