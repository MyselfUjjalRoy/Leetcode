class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        

        

        for (int idx = n - 1; idx >= 0; idx--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy <= 1; buy++) {
                for (int capacity = 1; capacity <= 2; capacity++) {
                    if (buy == 1) {
                        curr[buy][capacity] = Math.max(-prices[idx] + after[0][capacity] ,
                                0 + after[1][capacity]);
                    } else { // means buy = 0
                        curr[buy][capacity] = Math.max(prices[idx] + after[1][capacity - 1] ,
                                0 + after[0][capacity]);
                    }
                }
            }
            after = curr.clone();
        }

        return after[1][2];
    }
}