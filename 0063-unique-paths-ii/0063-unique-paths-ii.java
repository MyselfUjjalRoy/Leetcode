class Solution {
    int m , n;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(m - 1 , n - 1 , grid);
    }

    public int solve(int i , int j , int[][] grid){
        if(i < 0 || j < 0 || grid[i][j] == 1){
            return 0;
        }

        if(i == 0 && j == 0) return 1;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = solve(i - 1 , j , grid);
        int left = solve(i , j - 1 , grid);

        return dp[i][j] = up + left;
    }
}