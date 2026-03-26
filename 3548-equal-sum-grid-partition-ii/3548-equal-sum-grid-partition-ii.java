class Solution {
    long total = 0;
    public boolean checkHorizontalCuts(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;

        HashSet<Long> set = new HashSet<>();
        long topRowSum = 0;

        for(int i = 0; i < m - 1; i++){ // as we can cut till <= m - 2
            for(int j = 0; j < n; j++){
                set.add((long)grid[i][j]);
                topRowSum += grid[i][j];
            }

            long bottomRowSum = total - topRowSum;
            long diff = topRowSum - bottomRowSum;

            if(diff == 0) return true;

            if(diff == grid[0][0]) return true;

            if(diff == grid[0][n - 1]) return true;

            if(diff == grid[i][0]) return true; // suppose 1 col and i cut the curr row i so possible

            if(i > 0 && n > 1 && set.contains(diff)){// edge case 1 col : and i need to remove middle cell then not possible but if multiple col then it is possible 
                return true;
            }
        }

        return false;
    }
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // calculate total 
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                total += grid[i][j];
            }
        }

        // check horizontal cut
        if(checkHorizontalCuts(grid)) return true;

        reverse(grid);

        if(checkHorizontalCuts(grid)) return true;

        reverse(grid); // again original grid

        // transpose the matrix to check vertical cut
        int[][] transposedGrid = new int[n][m]; // careful it will be n X m not m X n

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                transposedGrid[j][i] = grid[i][j];
            }
        }

        if(checkHorizontalCuts(transposedGrid)) return true;

        reverse(transposedGrid);

        return checkHorizontalCuts(transposedGrid);
    }

    public void reverse(int[][] grid){
        int top = 0 , bottom = grid.length - 1;

        while(top < bottom){
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;
            top++;
            bottom--;
        }
    }
}