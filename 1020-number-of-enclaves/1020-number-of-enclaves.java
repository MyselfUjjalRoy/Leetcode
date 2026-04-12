class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

       
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1) dfs(m , n , i , 0 , grid);
            if(grid[i][n - 1] == 1) dfs(m , n , i , n - 1 , grid);
        }

        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1) dfs(m , n , 0 , j , grid );
            if(grid[m - 1][j] == 1) dfs(m , n , m - 1 , j , grid);
        }

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
    int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};
    public void dfs(int m , int n , int i , int j , int[][] grid){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 1){
            return;
        }

        grid[i][j] = 2;

        for(int d = 0; d < 4; d++){
            int nI = i + dir[2 * d];
            int nJ = j + dir[2 * d + 1];

            dfs(m , n , nI , nJ , grid);
        }
    }
}