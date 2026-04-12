class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(n - 1 , amount , coins);
    }

    public int solve(int idx , int amount , int[] coins){
        if(idx == 0){
            return amount % coins[idx] == 0 ? 1 : 0;
        }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }

        int skip = solve(idx - 1 , amount , coins);
        int take = 0;

        if(coins[idx] <= amount){
            take = solve(idx , amount - coins[idx] , coins);
        }

        return dp[idx][amount] = take + skip;
    }
}