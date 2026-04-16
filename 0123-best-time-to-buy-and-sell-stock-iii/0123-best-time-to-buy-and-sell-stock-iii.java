class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i < n; i++) { // base case 1 -> if(capacity == 0) return 0;  we can also avoid it because the value is already 0 , but i have written it for my own understanding
            for (int buy = 0; buy < 2; buy++) {
                dp[i][buy][0] = 0;
            }
        }

        for (int buy = 0; buy < 2; buy++) { // base case 2 -> if(idx == n) return 0;
            for (int capacity = 0; capacity < 3; capacity++) {
                dp[n][buy][capacity] = 0;
            }
        }

        for (int idx = n - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int capacity = 1; capacity <= 2; capacity++) {
                    if (buy == 1) {
                        dp[idx][buy][capacity] = Math.max(-prices[idx] + dp[idx + 1][0][capacity] ,
                                0 + dp[idx + 1][1][capacity]);
                    } else { // means buy = 0
                        dp[idx][buy][capacity] = Math.max(prices[idx] + dp[idx + 1][1][capacity - 1] ,
                                0 + dp[idx + 1][0][capacity]);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}