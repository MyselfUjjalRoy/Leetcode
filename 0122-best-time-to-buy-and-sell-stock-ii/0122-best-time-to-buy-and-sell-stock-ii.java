class Solution {
    int n;
    int dp[][];
    public int solve(int idx , int buy , int[] prices){
        if(idx == n){
            return 0;
        }

        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;

        if(buy == 1){ // means i want to buy
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , prices) , 0 + solve(idx + 1 , 1 , prices));
        }
        else{
            profit = Math.max(prices[idx] + solve(idx + 1 , 1 , prices) , 0 + solve(idx + 1 , 0 , prices));
        }
        return dp[idx][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        n = prices.length;

        dp = new int[n][2];
        for(int  i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 1 , prices); // 1 -> i want to buy
    }
}