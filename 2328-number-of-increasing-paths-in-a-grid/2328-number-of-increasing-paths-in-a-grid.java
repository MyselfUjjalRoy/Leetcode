class Solution {
    // codestory with mik

    int[][] dp;
    int m , n;
    int[] dir  = {-1 , 0 , 1 , 0 , 0 , - 1 , 0 , 1};
    int MOD = (int)1e9 + 7;
    public int dfs(int i , int j , int[][] grid){
        if(dp[i][j] != -1) return dp[i][j];
        int result = 1; // grid[i][j] -> itselft is increasing

        for(int d = 0; d < 4; d++){
            int i_ = i + dir[2 * d];
            int j_ = j + dir[2 * d + 1];

            if(isSafe(i_ , j_) && grid[i_][j_] < grid[i][j]){
                result = (result + dfs(i_ , j_ , grid)) % MOD;
            }
        }

        return dp[i][j] = result % MOD;
    }
    public boolean isSafe(int i , int j){
        return i >= 0 && j >= 0 && i < m && j < n;
    }
    public int countPaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans = (ans + dfs(i , j , grid)) % MOD;
            }
        }

        return ans;
    }
}