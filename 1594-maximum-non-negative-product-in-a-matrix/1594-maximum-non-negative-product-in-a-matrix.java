class Solution {
    class Pair{
        long max , min;
        Pair(long max , long min){
            this.max = max;
            this.min = min;
        }
    }

    Pair[][] dp;
    int m , n;
    int MOD = (int)1e9 + 7;
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new Pair[m][n];

        Pair p = solve(0 , 0 , grid);

        if(p.max < 0){
            return -1;
        }
        else{
            return (int)(p.max % MOD);
        }
    }

    public Pair solve(int i , int j , int[][] grid){
        if(i == m - 1 && j == n - 1){
            return new Pair(grid[m - 1][n - 1] , grid[m - 1][n - 1]);
        }

        if(dp[i][j] != null){
            return dp[i][j];
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;

        if(i + 1 < m){
            Pair down = solve(i + 1 , j , grid);

            long a = down.max * grid[i][j];
            long b = down.min * grid[i][j];

            max = Math.max(max , Math.max(a , b));
            min = Math.min(min , Math.min(a , b));
        }
        if(j + 1 < n){
            Pair right = solve(i , j + 1 , grid);

            long a = right.max * grid[i][j];
            long b = right.min * grid[i][j];

            max = Math.max(max , Math.max(a , b));
            min = Math.min(min , Math.min(a , b));
        }

        return dp[i][j] = new Pair(max , min);
    }
}