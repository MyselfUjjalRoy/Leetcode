class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        dp = new int[n][amount + 1];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        int ans = solve(n - 1 , amount , coins);

        return ans == (int)1e9 ? -1 : ans;
    }

    public int solve(int idx , int amount , int[] coins){
        if(idx == 0){
            if(amount % coins[0] == 0) return amount / coins[0];
            else return (int)1e9;
        }

        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }

        int skip = solve(idx - 1 , amount , coins);
        int take = (int)1e9; // as we need to find minimum coins
        if(coins[idx] <= amount){
            take = 1 + solve(idx , amount - coins[idx] , coins); // Note : idx - 1 nahi karenge , infinite supply
        }

        return dp[idx][amount] = Math.min(take , skip);
    }
}