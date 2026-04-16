class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] prev = new int [2];

        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[idx] + prev[0],
                            prev[1]);
                } else {
                    curr[buy] = Math.max(prices[idx] - fee + prev[1],
                            prev[0]);
                }
            }
            prev = curr;
        }

        return prev[1];
    }
}