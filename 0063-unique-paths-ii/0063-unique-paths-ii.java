class Solution {
    int[][] t;
    public int solve(int i , int j , int m , int n , int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 0){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if((i == m - 1 && j == n - 1)){
            return 1;
        }

        int right = solve(i + 1, j , m , n , grid);
        int bottom = solve(i , j + 1 , m , n , grid);

        return t[i][j] = right + bottom;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if((grid[m - 1][n - 1] == 1) || (grid[0][0] == 1)){
            return 0;
        }

        t = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(0 , 0 , m , n , grid);
    }
}