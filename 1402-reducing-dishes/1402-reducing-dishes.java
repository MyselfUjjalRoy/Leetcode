class Solution {
    int n;
    public int solve(int[] satisfaction , int i , int time , int[][] dp){
        if(i >= n){
            return 0;
        }
        
        if(dp[i][time] != -1){
            return dp[i][time];
        }

        int include = satisfaction[i] * time + solve(satisfaction , i + 1 , time + 1 , dp);

        int exclude = solve(satisfaction , i + 1 , time , dp);

        return dp[i][time] = Math.max(include , exclude);
    }
    public int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        Arrays.sort(satisfaction);

        int[][] dp = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(satisfaction , 0 , 1 , dp);
    }
}