class Solution {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int[][] t = new int[n][n];

        for(int col = 0; col < n; col++){
            t[0][col] = mat[0][col];
        }
        
        for(int row = 1; row < n; row++){
            for(int col = 0; col < n; col++){
                t[row][col] = mat[row][col] + Math.min(t[row - 1][col] , Math.min(t[row - 1][Math.max(0 , col - 1)] , t[row - 1][Math.min(n - 1 , col + 1)]));
            }
        }

        return Arrays.stream(t[n - 1]).min().orElse(0);
    }
}