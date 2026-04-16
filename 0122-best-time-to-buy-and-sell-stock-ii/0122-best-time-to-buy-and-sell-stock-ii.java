class Solution {
    /*
    this solution uses 4 variable to make it optimized , though it is same as space optimized approach 
    because it lot of leetcode solution forum , this method is used , so keep it in mind
    the space complexity is same as using prev and curr array 
    */
    public int maxProfit(int[] prices) {
        int n = prices.length;

        long aheadNotBuy, aheadBuy, currNotBuy, currBuy;

        aheadNotBuy = aheadBuy = 0;

        for (int idx = n - 1; idx >= 0; idx--) {

            currBuy = Math.max(-prices[idx] + aheadNotBuy, 0 + aheadBuy);

            currNotBuy = Math.max(prices[idx] + aheadBuy, 0 + aheadNotBuy);

            aheadBuy = currBuy;
            aheadNotBuy = currNotBuy;

        }

        return (int)aheadBuy;
    }
}