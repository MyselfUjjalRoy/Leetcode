class Solution {
    boolean[][] visited;
    int n;
    int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};
    public int swimInWater(int[][] grid) {
        n = grid.length;
        int low = 0;
        int high = n * n - 1;

        int ans = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            visited = new boolean[n][n];
            if(isReachable(0 , 0 , mid , grid)){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean isReachable(int r , int c , int mid , int[][] grid){
        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] > mid || visited[r][c]){
            return false;
        }

        visited[r][c] = true;

        if(r == n - 1 && c == n - 1) return true;
        
        for(int d = 0; d < 4; d++){
            int nr = r + dir[2 * d];
            int nc = c + dir[2 * d + 1];

            if(isReachable(nr , nc , mid , grid)){
                return true;
            }
        }

        return false;
    }
}