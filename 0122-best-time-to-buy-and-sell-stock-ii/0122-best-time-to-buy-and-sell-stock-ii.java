class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for(int idx = n - 1; idx >= 0; idx--){
            for(int option = 0; option <= 1; option++){
                int profit = 0;

                if(option == 1){
                    profit = Math.max(-prices[idx] + dp[idx + 1][0] , 0 + dp[idx + 1][1]);
                }
                else{
                    profit = Math.max(prices[idx] + dp[idx + 1][1] , 0 + dp[idx + 1][0]);
                }

                dp[idx][option] = profit;
            }
        }

        return dp[0][1];
    }
}