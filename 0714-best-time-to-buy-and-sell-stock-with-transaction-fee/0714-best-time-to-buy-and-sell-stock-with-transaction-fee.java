class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n + 1][2];

        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }
        
        return solve(0 , 1 , fee , prices);
    }

    public int solve(int idx , int buy , int fee , int[] prices){
        if(idx == n){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;

        if(buy == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , fee , prices) , solve(idx + 1 , 1 , fee , prices));
        }
        else{
            profit = Math.max(prices[idx] - fee + solve(idx + 1 , 1 , fee , prices) , solve(idx + 1 , 0 , fee , prices));
        }

        return dp[idx][buy] = profit;
    }
}