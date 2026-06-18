class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 2][2];

        for(int idx = n - 1; idx >= 0; idx--){
            for(int option = 0; option <= 1; option++){
                if(option == 1){
                    dp[idx][option] = Math.max(-prices[idx] + dp[idx + 1][0] , 0 + dp[idx + 1][1]);
                }
                else{
                    dp[idx][option] = Math.max(prices[idx] + dp[idx + 2][1] , 0 + dp[idx + 1][0]);
                }
            }
        }

        return dp[0][1];
    }
}