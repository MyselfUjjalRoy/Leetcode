class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] dist = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i , j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            for(int d = 0; d < 4; d++){
                int nRow = row + dx[d];
                int nCol = col + dy[d];
                if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && dist[nRow][nCol] == -1){
                    queue.offer(new int[]{nRow , nCol});
                    dist[nRow][nCol] = dist[row][col] + 1;
                }
            }
        }
        return dist;
    }
}