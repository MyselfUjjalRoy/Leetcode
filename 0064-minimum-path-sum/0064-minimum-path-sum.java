class Solution {
    int[][] t;
    int m , n;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(grid , 0 , 0);
    }

    public int solve(int[][] grid , int i , int j){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }
        
        if(i == m - 1 && j == n - 1) return grid[m - 1][n - 1];

        int right = solve(grid , i , j + 1);
        int down = solve(grid , i + 1 , j);

        return t[i][j] = grid[i][j] + Math.min(right , down);
    }
}