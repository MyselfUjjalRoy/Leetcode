class Solution {
    int m , n;
    int[][][] dp;
    int[] colDir = {-1 , 0 , 1};

    public boolean isSafe(int col){
        return col >= 0 && col < n;
    }

    public int solve(int row , int col1 , int col2 , int[][] grid){
        if(row >= m){
            return 0;
        }

        if(dp[row][col1][col2] != -1){
            return dp[row][col1][col2];
        }

        int sum = grid[row][col1];
        if(col1 != col2){
            sum += grid[row][col2];
        }

        int ans = Integer.MIN_VALUE;

        for(int x : colDir){
            for(int y : colDir){
                int newCol1 = col1 + x;
                int newCol2 = col2 + y;

                if(isSafe(newCol1) && isSafe(newCol2)){
                    ans = Math.max(ans , solve(row + 1 , newCol1 , newCol2 , grid) );
                }
            }
        }

        return dp[row][col1][col2] = sum + ans;
    }
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[71][71][71];

        for(int i = 0; i < 71; i++){
            for(int j = 0; j < 71; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return solve(0 , 0 , n - 1 , grid); // [row , col1 , col2 , grid]
    }
}