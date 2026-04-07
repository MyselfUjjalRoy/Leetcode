class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(m - 1 , n - 1 , grid);
    }

    int solve(int i , int j , int[][] grid){
        if(i < 0 || j < 0) return Integer.MAX_VALUE;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == 0  && j == 0) return grid[0][0];

        int up = solve(i - 1 , j , grid);
        int left = solve(i , j - 1 , grid);

        return dp[i][j] = grid[i][j] + Math.min(up , left);
    }
}