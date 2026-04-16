class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];

        ahead[0] = ahead[1] = 0;

        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for(int buy = 0; buy <= 1; buy++){
                int profit = 0;

                if (buy == 1) { // means i want to buy
                    profit = Math.max(-prices[idx] + ahead[0], 0 + ahead[1]);
                } else {
                    profit = Math.max(prices[idx] + ahead[1], 0 + ahead[0]);
                }
                
                curr[buy] = profit;
            }
            ahead = curr.clone();
        }

        return ahead[1];
    }
}