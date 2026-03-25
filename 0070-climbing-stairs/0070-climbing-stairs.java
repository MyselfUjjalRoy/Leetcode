class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[46]; // as the size was 45
        Arrays.fill(dp , -1);

        return solve(n , dp);
    }
    public int solve(int n , int[] dp){
        if(n < 0) return 0;

        if(dp[n] != -1) return dp[n];

        if(n == 0) return 1;

        int oneStep = solve(n - 1 , dp);
        int twoStep = solve(n - 2 , dp);

        return dp[n] = oneStep + twoStep;
    }
}