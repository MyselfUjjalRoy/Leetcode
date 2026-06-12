class Solution {
    int M , N;
    int[][] dp;
    public int uniquePaths(int m, int n) {
        M = m;
        N = n;
        dp = new int[M][N];
        for(int i = 0; i < M; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(M - 1 , N - 1);
    }

    public int solve(int i , int j){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int left = solve(i , j - 1);
        int up = solve(i - 1 , j);

        return dp[i][j] = left + up;
    }
}