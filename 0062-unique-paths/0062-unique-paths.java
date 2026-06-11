class Solution {
    int[][] dp;
    int M , N;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        M = m;
        N = n;
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 0);
    }

    public int solve(int i , int j){
        if(i == M - 1 || j == N - 1) return 1;

        if(i > M - 1 || j > N - 1) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int up = solve(i + 1 , j);
        int left = solve(i , j + 1);

        return dp[i][j] = up + left;
    }
}