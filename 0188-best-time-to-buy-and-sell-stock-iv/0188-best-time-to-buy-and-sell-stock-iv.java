class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        for(int idx = n - 1; idx >= 0; idx--){
            for(int buy = 0; buy <= 1; buy++){
                for(int capacity = 1; capacity <= k; capacity++){
                    if(buy == 1){
            dp[idx][buy][capacity] = Math.max(-prices[idx] + dp[idx + 1][0][capacity] , 
            0 + dp[idx + 1][1][capacity]);
        }
        else{
            dp[idx][buy][capacity] = Math.max(prices[idx] + dp[idx + 1][1][capacity - 1] , 
            0 + dp[idx + 1][0][capacity]);
        } 
                }
            }
        }
        return dp[0][1][k];
    }
}