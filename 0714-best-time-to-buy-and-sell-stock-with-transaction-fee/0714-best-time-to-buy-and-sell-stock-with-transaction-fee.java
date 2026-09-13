class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 1 , prices , fee);
    }
    public int solve(int idx , int option , int[] prices , int fee){
        if(idx == n) return 0;
        if(dp[idx][option] != -1){
            return dp[idx][option];
        }

        int profit = 0;
        if(option == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , prices , fee) , solve(idx + 1 , 1 , prices , fee));
        }
        else{
            profit = Math.max(prices[idx] - fee + solve(idx + 1 , 1 , prices , fee) , solve(idx + 1 , 0 , prices , fee));
        }

        return dp[idx][option] = profit;
    }
}