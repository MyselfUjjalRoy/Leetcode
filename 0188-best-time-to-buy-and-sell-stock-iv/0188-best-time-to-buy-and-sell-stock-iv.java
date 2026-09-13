class Solution {
    int n;
    int[][][] dp;
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

    public int solve(int idx , int option , int k , int[] prices){
        if(idx == n || k == 0) return 0;
        if(dp[idx][option][k] != -1) return dp[idx][option][k];

        int profit = 0;

        if(option == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , k , prices) , 0 + solve(idx + 1 , 1 , k , prices));
        }
        else{
            profit = Math.max(prices[idx] + solve(idx + 1 , 1 , k - 1 , prices) , solve(idx + 1 , 0 , k , prices));
        }

        return dp[idx][option][k] = profit;
    }
}