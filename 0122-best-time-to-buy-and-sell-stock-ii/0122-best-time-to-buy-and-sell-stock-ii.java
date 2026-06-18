class Solution {
    int n;
    int[][] dp;
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 1 , prices); // 1 -> means I want to buy
    }

    public int solve(int idx , int option , int[] prices){
        if(idx == n){
            return 0;
        }

        if(dp[idx][option] != -1){
            return dp[idx][option];
        }

        int profit = 0;
        
        if(option == 1){ // means buy -> stock value -> subtracted
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , prices) , 0 + solve(idx + 1 , 1 , prices));
        }
        else{ // means sell -> stock value -> added
            profit = Math.max(prices[idx] + solve(idx + 1 , 1 , prices) , 0 + solve(idx + 1 , 0 , prices));
        }

        return dp[idx][option] = profit;
    }
}