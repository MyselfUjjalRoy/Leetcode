class Solution {
    int m;
    int n;
    boolean[][] visited;
    int[] dir = {-1 , 0 , 0 , -1 , 1 , 0 , 0 , 1};
    public boolean detectCycleDFS(int r , int c , int prevR , int prevC , char[][] grid){
        if(visited[r][c]){
            return true;
        }

        visited[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nR = r + dir[2 * d];
            int nC = c + dir[2 * d + 1];

            if(nR >= 0 && nC >= 0 && nR < m && nC < n && grid[nR][nC] == grid[r][c]){
                if(nR == prevR && nC == prevC){
                    continue;
                }

                if(detectCycleDFS(nR , nC , r , c , grid)){
                    return true;
                }
            }
        }

        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    if(detectCycleDFS(i , j , -1 , - 1 , grid)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}