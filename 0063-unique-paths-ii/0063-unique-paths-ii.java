class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] t = new int[m][n];

        for(int col = 0; col < n; col++){
            if(col > 0 && grid[0][col - 1] == 1){
                t[0][col] = 0;
                grid[0][col] = 1;
            }
            else if(grid[0][col] == 1){
                t[0][col] = 0;
            }
            else{
                t[0][col] = 1;
            }
        }

         for(int row = 0; row < m; row++){
            if(row > 0 && grid[row - 1][0] == 1){
                t[row][0] = 0;
                grid[row][0] = 1;
            }
            else if(grid[row][0] == 1){
                t[row][0] = 0;
            }
            else{
                t[row][0] = 1;
            }
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] == 1){
                    t[i][j] = 0;
                }
                else{
                    t[i][j] = t[i - 1][j] + t[i][j - 1];
                }
            }
        }

        return t[m - 1][n - 1];
    }
}