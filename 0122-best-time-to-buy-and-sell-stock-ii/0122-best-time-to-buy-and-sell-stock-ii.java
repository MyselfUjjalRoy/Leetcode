class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev = new int[2];

        prev[0] = prev[1] = 0;

        for(int idx = n - 1; idx >= 0; idx--){
            int[] curr = new int[2];
            for(int option = 0; option <= 1; option++){
                int profit = 0;

                if(option == 1){
                    profit = Math.max(-prices[idx] + prev[0] , 0 + prev[1]);
                }
                else{
                    profit = Math.max(prices[idx] + prev[1] , 0 + prev[0]);
                }

                curr[option] = profit;
            }
            prev = curr;
        }

        return prev[1];
    }
}