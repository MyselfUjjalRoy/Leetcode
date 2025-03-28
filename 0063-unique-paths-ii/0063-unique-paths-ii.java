class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
       int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];  
        
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return recursion(m - 1, n - 1, obstacleGrid, dp);
    }

    public int recursion(int m, int n, int[][] obstacleGrid, int[][] dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) return 0;
        if (dp[m][n] != -1) return dp[m][n];

        dp[m][n] = recursion(m - 1, n, obstacleGrid, dp) + recursion(m, n - 1, obstacleGrid, dp);
        return dp[m][n];
    }
}