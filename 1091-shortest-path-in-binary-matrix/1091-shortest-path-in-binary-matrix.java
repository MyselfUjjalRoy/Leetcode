class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0 , 0 , 1});

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1 , -1 , -1 , -1 , 1 , 1 , 1 , 1 , -1};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];

            if(r == n - 1 && c == n - 1) return dist;
            
            for(int d  = 0; d < 8; d++){
                int nR = r + dir[2 * d];
                int nC = c + dir[2 * d + 1];

                if(nR >= 0 && nC >= 0 && nR < n && nC < n && !visited[nR][nC] && grid[nR][nC] == 0){
                    visited[nR][nC] = true;
                    queue.offer(new int[]{nR , nC , dist + 1});
                }
            }
        }

        return -1;
    }
}