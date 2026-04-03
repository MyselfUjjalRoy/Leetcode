class Solution {
    class Pair {
        long max , min;
        Pair(long max , long min){
            this.max = max;
            this.min = min;
        }
    }
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 1000000007;

        Pair[][] t = new Pair[m][n];

        t[0][0] = new Pair(grid[0][0] , grid[0][0]);

        // fill first row
        for(int j = 1; j < n; j++){
            int val = grid[0][j];

            long a = val * t[0][j - 1].max;
            long b = val * t[0][j - 1].min;

            t[0][j] = new Pair(Math.max(a , b) , Math.min(a , b));
        }

        // fill the first column
        for(int i = 1; i < m; i++){
            int val = grid[i][0];

            long a = val * t[i - 1][0].max;
            long b = val * t[i - 1][0].min;

            t[i][0] = new Pair(Math.max(a , b) , Math.min(a , b));
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                int val = grid[i][j];

                long a = t[i - 1][j].max * val;
                long b = t[i - 1][j].min * val;
                long c = t[i][j - 1].max * val;
                long d = t[i][j - 1].min * val;

                long max = Math.max(Math.max(a , b) , Math.max(c , d));
                long min = Math.min(Math.min(a , b) , Math.min(c , d));

                t[i][j] = new Pair(max , min);
            }
        }

        if(t[m - 1][n - 1].max < 0){
            return -1;
        }
        else{
            return (int)(t[m - 1][n - 1].max % MOD);
        }
    }
}