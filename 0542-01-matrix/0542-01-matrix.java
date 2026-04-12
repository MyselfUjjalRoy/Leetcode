class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i , j});
                }
                else{
                    dist[i][j] = -1;
                }
            }
        }

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int d = 0; d < 4; d++){
                int nR = r + dir[2 * d];
                int nC = c + dir[2 * d + 1];

                if(nR >= 0 && nC >= 0 && nR < m && nC < n && dist[nR][nC] == -1){
                    queue.offer(new int[]{nR , nC});
                    dist[nR][nC] = dist[r][c] + 1;
                }
            }
        }

        return dist;
    }

    
}