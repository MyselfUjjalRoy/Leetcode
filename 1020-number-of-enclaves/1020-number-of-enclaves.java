class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            if(grid[i][0] == 1) dfs(n , m  , i , 0 , grid);
            if(grid[i][m - 1] == 1) dfs(n , m , i , m - 1 , grid);
        }
        for(int j = 0; j < m; j++){
            if(grid[0][j] == 1) dfs(n , m , 0 , j , grid);
            if(grid[n - 1][j] == 1) dfs(n , m , n - 1 , j , grid);
        }
        int lands = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    lands++;
                }
            }
        }
        return lands;
    }
    public void dfs(int n , int m , int row , int col , int[][] board){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 1) return;
        
        board[row][col] = 2;
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int i = 0; i < 4; i++){
            int nRow = row + dx[i];
            int nCol = col + dy[i];

            dfs(n , m , nRow , nCol , board);
        }
    }
}