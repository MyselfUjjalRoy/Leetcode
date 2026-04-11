class Solution {
    int[][] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[n][amount + 1];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        int ans = solve(n - 1, amount , coins);

        return ans == (int)1e9 ? -1 : ans;
    }

    public int solve(int idx , int target , int[] coins){
        if(idx == 0){
            if((target % coins[idx]) == 0) return target / coins[idx];
            else return (int)1e9;
        }

        int notTake = 0 + solve(idx - 1 , target , coins);
        int take = (int)1e9;
        if(coins[idx] <= target){
            take = 1 + solve(idx , target - coins[idx] , coins);
        }

        return dp[idx][target] = Math.min(take , notTake);
    }
}