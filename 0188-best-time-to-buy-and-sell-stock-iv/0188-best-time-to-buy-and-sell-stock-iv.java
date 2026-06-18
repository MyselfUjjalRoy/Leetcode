class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][3][k + 1];

        for(int i = 0; i < n + 1; i++){
            for(int option = 0; option <= 2; option++){
                dp[i][option][0] = 0;
            }
        }

        for(int option = 0; option <= 2; option++){
            for(int capacity = 0; capacity < k + 1; capacity++){
                dp[n][option][capacity] = 0;
            }
        }

        for(int idx = n - 1; idx >= 0; idx--){
            for(int option = 0; option <= 1; option++){
                for(int capacity = 1; capacity <= k; capacity++){
                    int profit = 0;

                    if(option == 1){
                        profit = Math.max(-prices[idx] + dp[idx + 1][0][capacity] , 0 + dp[idx + 1][1][capacity]);
                    }
                    else{
                        profit = Math.max(prices[idx] + dp[idx + 1][1][capacity - 1] , 0 + dp[idx + 1][0][capacity]);
                    }

                    dp[idx][option][capacity] = profit;
                }
            }
        }

        return dp[0][1][k];
    }
}