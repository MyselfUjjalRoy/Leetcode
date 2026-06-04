class Solution {
    int m , n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int islands = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(i , j , grid);
                    islands++;
                }
            }
        }

        return islands;
    }
    
    int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

    public void dfs(int r , int c , char[][] grid){
        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != '1'){
            return;
        }

        grid[r][c] = '2';

        for(int d = 0; d < 4; d++){
            int nR = r + dir[2 * d];
            int nC = c + dir[2 * d + 1];

            dfs(nR , nC , grid);
        }
    }
}