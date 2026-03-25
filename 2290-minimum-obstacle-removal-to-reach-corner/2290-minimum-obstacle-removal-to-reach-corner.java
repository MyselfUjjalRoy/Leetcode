class Solution {
    /* codestory with mik
        idea is - just consider the obstacles as 1 and other as 0 then apply dijkstra's algo
    */
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(result[i] , Integer.MAX_VALUE);
        } 

        result[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b)-> a[0] - b[0]);
        pq.offer(new int[]{0 , 0 , 0}); // {wt , i , j}

        int[] dir = {-1 , 0 , 1, 0 , 0 , -1 , 0 , 1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int obstacleCount = curr[0];
            int i = curr[1];
            int j = curr[2];

            for(int d = 0; d < 4; d++){
                int x = i + dir[2 * d];
                int y = j + dir[2 * d + 1];

                if(x >= 0 && y >= 0 && x < m && y < n){
                    int wt = (grid[x][y] == 1) ? 1 : 0;

                    if(obstacleCount + wt < result[x][y]){
                        result[x][y] = obstacleCount + wt;
                        pq.offer(new int[]{result[x][y] , x , y});
                    }
                }
            }
        }

        return result[m - 1][n - 1];
    }
}