class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for(int i = 0; i < n + 1; i++){ // base case 2 -> capacity == 0
            for(int option = 0; option <= 1; option++){
                dp[i][option][0] = 0;
            }
        }

        for(int option = 0; option <= 1; option++){ // base case 1 -> idx == n
            for(int capacity = 0; capacity <= 2; capacity++){
                dp[n][option][capacity] = 0;
            }
        }

        for(int idx = n - 1; idx >= 0; idx--){
            for(int option = 0; option <= 1; option++){
                for(int capacity = 1; capacity <= 2; capacity++){
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

        return dp[0][1][2];
    }
}