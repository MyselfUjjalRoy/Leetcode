class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] prev = new int[n + 1][n + 1];

        for(int j1 = 0; j1 < n; j1++){
            for(int j2 = 0; j2 < n; j2++){
                if(j1 == j2){
                    prev[j1][j2] = grid[m - 1][j1];
                }
                else{
                    prev[j1][j2] = grid[m - 1][j1] + grid[m - 1][j2];
                }
            }
        }

        for(int i = m - 2; i >= 0; i--){
            int[][] curr = new int[n + 1][n + 1];
            for(int j1 = 0; j1 < n; j1++){
                for(int j2 = 0; j2 < n; j2++){
                    int best = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1 <= 1; dj1++){
                        for(int dj2 = -1; dj2 <= 1; dj2++){
                            int nj1 = j1 + dj1;
                            int nj2 = j2 + dj2;

                            if(nj1 >= 0 && nj1 < n && nj2 >= 0 && nj2 < n){
                                int value = 0;
                                if(j1 == j2){
                                    value = grid[i][j1];
                                }
                                else{
                                    value = grid[i][j1] + grid[i][j2];
                                }

                                value += prev[nj1][nj2];

                                best = Math.max(best , value);
                            }
                        }
                    }
                    curr[j1][j2] = best;
                }
            }
            prev = curr;
        }

        return prev[0][n - 1];
    }
}