class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] prev1 = new int[2];
        int[] prev2 = new int[2];

        for(int idx = n - 1; idx >= 0; idx--){
            int[] curr = new int[2];
            for(int option = 0; option <= 1; option++){
                if(option == 1){
                    curr[option] = Math.max(-prices[idx] + prev1[0] , 0 + prev1[1]);
                }
                else{
                    curr[option] = Math.max(prices[idx] + prev2[1] , 0 + prev1[0]);
                }
            }
            
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1[1];
    }
}