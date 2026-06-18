class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 1 , prices);
    }

    public int solve(int idx , int option , int[] prices){
        if(idx >= n) return 0;
        
        if(dp[idx][option] != -1){
            return dp[idx][option];
        }

        int profit = 0;

        if(option == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , prices) , 0 + solve(idx + 1 , 1 , prices));
        }
        else{
            profit = Math.max(prices[idx] + solve(idx + 2 , 1 , prices) , 0 + solve(idx + 1 , 0 , prices));
        }

        return dp[idx][option] = profit;
    }
}