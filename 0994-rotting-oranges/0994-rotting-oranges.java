class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                else if(grid[i][j] == 2){
                    queue.offer(new int[]{i , j});
                }
            }
        }

        int time = 0;
        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean anyRot = false;

            while(size-- > 0){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for(int d = 0; d < 4; d++){
                    int nR = r + dir[2 * d];
                    int nC = c + dir[2 * d + 1];

                    if(nR >= 0 && nC >= 0 && nR < m && nC < n && grid[nR][nC] == 1){
                        queue.offer(new int[]{nR , nC});
                        fresh--;
                        grid[nR][nC] = 2;
                        anyRot = true;
                    }
                }
            }

            if(anyRot) time++;
        }

        return fresh == 0 ? time : -1;
    }
}