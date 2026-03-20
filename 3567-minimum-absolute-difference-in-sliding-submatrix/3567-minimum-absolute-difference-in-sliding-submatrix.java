class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] ans = new int[m - k + 1][n - k + 1];

        for(int i = 0; i < m - k + 1; i++){
            for(int j = 0; j < n - k + 1; j++){
                TreeSet<Integer> set = new TreeSet<>();
                for(int r = i; r < i + k; r++){
                    for(int c = j; c < j + k; c++){
                        set.add(grid[r][c]);
                    }
                }

                if(set.size() == 1) continue;

                int minDiff = Integer.MAX_VALUE;
                Integer prev = null;

                for(int val : set){
                    if(prev != null){
                        minDiff = Math.min(minDiff , val - prev);
                    }
                    prev = val;
                }
                
                ans[i][j] = (minDiff == Integer.MAX_VALUE) ? 0 : minDiff;
            }
        }
        return ans;
    }
}