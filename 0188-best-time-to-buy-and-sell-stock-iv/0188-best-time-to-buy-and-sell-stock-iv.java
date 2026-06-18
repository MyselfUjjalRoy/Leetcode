class Solution {
    int n;
    int[][][] dp;
    public int maxProfit(int k, int[] prices) {
        n = prices.length;
        dp = new int[n + 1][2][k + 1];

        for(int i = 0; i < n + 1; i++){
            for(int opt = 0; opt < 2; opt++){
                Arrays.fill(dp[i][opt] , -1);
            }
        }

        return solve(0 , 1 , k , prices);
    }

    public int solve(int idx , int option , int k , int[] prices){
        if(idx == n) return 0;
        if(k == 0) return 0;

        if(dp[idx][option][k] != -1){
            return dp[idx][option][k];
        }

        int profit = 0;

        if(option == 1){
            profit = Math.max(-prices[idx] + solve(idx + 1 , 0 , k , prices) , 0 + solve(idx + 1 , 1 , k , prices));
        }
        else{
            profit = Math.max(prices[idx] + solve(idx + 1 , 1 , k - 1 , prices) , 0 + solve(idx + 1 , 0 , k , prices));
        }

        return dp[idx][option][k] = profit;
    }
}