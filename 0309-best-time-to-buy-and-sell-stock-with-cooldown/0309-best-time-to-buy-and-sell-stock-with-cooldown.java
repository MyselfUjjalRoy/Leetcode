class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] front1 = new int[2];
        int[] front2 = new int[2];

        for (int idx = n - 1; idx >= 0; idx--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) {
                    curr[buy] = Math.max(-prices[idx] + front1[0], front1[1]);
                } else {
                    curr[buy] = Math.max(prices[idx] + front2[1], front1[0]);
                }
            }
            
            front2 = front1;
            front1 = curr;
        }

        return front1[1];
    }
}