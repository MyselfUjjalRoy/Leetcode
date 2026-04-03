class Solution {
    /* example dry run for better understanding :- 
    [[1 , -2 , 3]
     [1 , 4 , -2]
     [2 , 3 , 4 ]
    ]

    */
    class Pair{
        long max;
        long min;
        Pair(long max , long min){
            this.max = max;
            this.min = min;
        }
    }
    
    Pair[][] t;  // t[i][j] -> {max , min}
    int m , n;
    int MOD = 1000000007;
    public Pair solve(int i , int j , int[][] grid){
        if(i == m - 1 && j == n - 1){
            return new Pair(grid[i][j] , grid[i][j]);
        }

        if(t[i][j] != null){
            return t[i][j];
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

        return t[i][j] = new Pair(max , min);
    }
    public int maxProductPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new Pair[m][n];

        Pair p = solve(0 , 0 , grid);

        if(p.max < 0){
            return -1;
        }
        else{
            return (int)(p.max % MOD);
        }
    }
}