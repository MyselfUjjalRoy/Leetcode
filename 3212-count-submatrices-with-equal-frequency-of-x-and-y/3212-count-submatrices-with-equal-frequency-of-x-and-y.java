class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] cumulativeSumX = new int[n][m];
        int[][] cumulativeSumY = new int[n][m];

        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int isX = grid[i][j] == 'X' ? 1 : 0;
                int isY = grid[i][j] == 'Y' ? 1 : 0;

                cumulativeSumX[i][j] = isX;
                cumulativeSumY[i][j] = isY;

                if(i > 0){
                    cumulativeSumX[i][j] += cumulativeSumX[i - 1][j];
                    cumulativeSumY[i][j] += cumulativeSumY[i - 1][j];
                }
                if(j > 0){
                    cumulativeSumX[i][j] += cumulativeSumX[i][j - 1];
                    cumulativeSumY[i][j] += cumulativeSumY[i][j - 1];
                }
                if(i > 0 && j > 0){
                    cumulativeSumX[i][j] -= cumulativeSumX[i - 1][j - 1];
                    cumulativeSumY[i][j] -= cumulativeSumY[i - 1][j - 1];
                }
                
                if(cumulativeSumX[i][j] == cumulativeSumY[i][j] && cumulativeSumX[i][j] > 0){
                    count++;
                }
            }
        }
        return count;
    }
}