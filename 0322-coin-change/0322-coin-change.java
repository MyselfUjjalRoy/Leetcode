class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for(int t = 0; t <= amount; t++){
            if((t % coins[0]) == 0){
                prev[t] = t / coins[0];
            }
            else{
                prev[t] = (int)1e9;
            }
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[amount + 1];
            for(int t = 0; t <= amount; t++){
                int notTake = prev[t];

                int take = (int)1e9;
                if(coins[i] <= t) take = 1 + curr[t - coins[i]];

                curr[t] = Math.min(take , notTake);
            }
            prev = curr.clone();
        }

        return prev[amount] == (int)1e9 ? -1 : prev[amount];
    }
}