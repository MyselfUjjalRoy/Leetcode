class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for(int col = 1; col < n; col++){
            dp[0][col] = grid[0][col] + dp[0][col - 1];
        }

        for(int row = 1; row < m; row++){
            dp[row][0] = grid[row][0] + dp[row - 1][0];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int left = dp[i][j - 1];
                int up = dp[i - 1][j];

                dp[i][j] = Math.min(left , up) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}