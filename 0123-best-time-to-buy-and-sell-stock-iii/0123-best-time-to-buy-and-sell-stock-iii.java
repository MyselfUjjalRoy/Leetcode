class Solution {
    int n;
    int[][][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;

        dp = new int[n + 1][2][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= 1; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return solve(0 , 1 , 2 , prices);
    }

    public int solve(int idx , int option , int capacity , int[] prices){
        if(idx == n) return 0;
        if(capacity == 0) return 0;

        if(dp[idx][option][capacity] != -1){
            return dp[idx][option][capacity];
        }

        int profit = 0;

        if(option == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , capacity , prices) , 0 + solve(idx + 1 , 1 , capacity , prices));
        }
        else{
            profit = Math.max(prices[idx] + solve(idx + 1 , 1 , capacity - 1 , prices) , 0 + solve(idx + 1 , 0 , capacity , prices));
        }

        return dp[idx][option][capacity] = profit;
    }
}