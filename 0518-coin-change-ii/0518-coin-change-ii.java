class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[] prev = new int[amount + 1];

        for(int t = 0; t <= amount; t++){
            if((t % coins[0]) == 0){
                prev[t] = 1;
            }
            else{
                prev[t] = 0;
            }
        }

        for(int i = 1; i < n; i++){
            int[] curr = new int[amount + 1];
            for(int t = 0; t <= amount; t++){
                int skip = prev[t];
                int take = 0;
                if(coins[i] <= t){
                    take = curr[t - coins[i]];
                }
                curr[t] = take + skip;
            }
            prev = curr.clone();
        }

        return prev[amount];
    }
}