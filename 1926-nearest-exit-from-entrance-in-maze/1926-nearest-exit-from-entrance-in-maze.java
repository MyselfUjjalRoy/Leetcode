class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0] , entrance[1]});

        int distance = 0;

        boolean[][] visited = new boolean[n][m];
        int[] dx = {0 , 1 , 0 , -1};
        int[] dy = {-1 , 0 , 1 , 0};

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                

                if(!(r == entrance[0] && c == entrance[1]) && (r == 0 || c == 0 || r == n - 1 || c == m - 1)){
                    return distance;
                }

                for(int d = 0; d < 4; d++){
                    int nRow = r + dx[d];
                    int nCol = c + dy[d];

                    if(nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && !visited[nRow][nCol] && maze[nRow][nCol] != '+'){
                        visited[nRow][nCol] = true;
                        queue.offer(new int[]{nRow , nCol});
                    }
                }

            }
            distance++;
        }

        return -1;
    }
}