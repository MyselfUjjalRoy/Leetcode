class Solution {
    class Pair{
        long max , min;
        Pair(long max , long min){
            this.max = max;
            this.min = min;
        }
    }
    
    int m , n;
    Pair[][] dp;
    int MOD = (int)1e9 + 7;

    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Pair[m][n];

        dp[0][0] = new Pair(grid[0][0] , grid[0][0]);

        // filling first row 
        for(int col = 1; col < n; col++){
            long a = grid[0][col] * dp[0][col - 1].max;
            long b = grid[0][col] * dp[0][col - 1].min;

            dp[0][col] = new Pair(Math.max(a , b) , Math.min(a , b));
        }

        // filling first col
        for(int row = 1; row < m; row++){
            long a = grid[row][0] * dp[row - 1][0].max;
            long b = grid[row][0] * dp[row - 1][0].min;

            dp[row][0] = new Pair(Math.max(a , b) , Math.min(a , b));
        }

        for(int i = 1; i < m; i++){
           for(int j = 1; j < n; j++){
                int val = grid[i][j];

                long a = dp[i - 1][j].max * val;
                long b = dp[i - 1][j].min * val;
                long c = dp[i][j - 1].max * val;
                long d = dp[i][j - 1].min * val;

                long max = Math.max(Math.max(a , b) , Math.max(c , d));
                long min = Math.min(Math.min(a , b) , Math.min(c , d));

                dp[i][j] = new Pair(max , min);
           }
        }

        if(dp[m - 1][n - 1].max < 0){
            return -1;
        }
        else{
            return (int)(dp[m - 1][n - 1].max % MOD);
        }
    }
}