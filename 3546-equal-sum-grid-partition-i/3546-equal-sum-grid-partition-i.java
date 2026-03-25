class Solution {
    public boolean canPartitionGrid(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        long total = 0;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                total += grid[i][j];

        if (total % 2 != 0) return false;
        long half = total / 2;

        long rowRunningSum = 0;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++)
                rowRunningSum += grid[i][j];
            if (rowRunningSum == half) return true;
        }

        long colRunningSum = 0;
        for (int j = 0; j < n - 1; j++) {
            for (int i = 0; i < m; i++) {
                colRunningSum += grid[i][j];
            }
            if (colRunningSum == half) return true;
        }

        return false;
    }
}