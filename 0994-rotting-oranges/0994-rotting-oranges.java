class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0)
            return 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyRot = false;

            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];

                for(int d = 0; d < 4; d++){
                    int nRow = row + dx[d];
                    int nCol = col + dy[d];

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1){
                        grid[nRow][nCol] = 2;
                        queue.offer(new int[]{nRow , nCol});
                        fresh--;
                        anyRot = true;
                    }
                }
            }
            if(anyRot) time++;

        }
        return fresh == 0 ? time : -1;
    }
}