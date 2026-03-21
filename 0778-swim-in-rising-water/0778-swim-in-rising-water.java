class Solution {
    int n;
    boolean[][] visited;
    int[][] directions = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};
    public int swimInWater(int[][] grid) {
        n = grid.length;
        int l = 0 , r = n * n - 1;

        int ans = 0;

        while(l <= r){
            int mid = l + (r - l) / 2;
            visited = new boolean[n][n];

            if(isReachable(grid , 0 , 0 , mid)){
                ans = mid;
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return ans;
    }
    public boolean isReachable(int[][] grid , int r , int c , int mid){
        if(r < 0 || c < 0 || r >= n || c >= n || grid[r][c] > mid || visited[r][c]){
            return false;
        }

        visited[r][c] = true;

        if(r == n - 1 && c == n - 1) return true;

        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(isReachable(grid , nr , nc , mid)){
                return true;
            }
        }
        return false;
    }
}