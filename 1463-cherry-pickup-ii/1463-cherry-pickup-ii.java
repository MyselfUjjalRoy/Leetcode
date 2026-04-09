//Approach-2 (Bottom Up - 3D Array)
//T.C : O(row*col*col * 9)
//S.C : O(row * col * col)
class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] t = new int[71][71][71];

         // t[row][c1][c2] = max cherries that can be collected till (row, c1) by robot1 and (row, c2) by robot2
        // return max in last row

        // For first row (robot 1 is in 0 th column) and robot 2 is int (n - 1) th column

        t[0][0][n - 1] = (n == 1) ? grid[0][0] : grid[0][0] + grid[0][n - 1];

        for(int row = 1; row < m; row++){
            for(int col1 = 0; col1 <= Math.min(n - 1 , row); col1++){ // min is taken because if there is only 1 column
                for(int col2 = Math.max(0 , n - 1 - row); col2 < n; col2++){
                    int prevMax = 0;

                    // A robot can come to the current column from either column - 1 , column or column + 1 of the prev row (row - 1)

                    for(int c1 = Math.max(0 , col1 - 1); c1 <= Math.min(n - 1 , col1 + 1); c1++){
                        for(int c2 = Math.max(0 , col2 - 1); c2 <= Math.min(n - 1 , col2 + 1); c2++){
                            prevMax = Math.max(prevMax , t[row - 1][c1][c2]);
                        }
                    }

                    if(col1 == col2){
                        t[row][col1][col2] = prevMax + grid[row][col1];
                    }
                    else{
                        t[row][col1][col2] = prevMax + grid[row][col1] + grid[row][col2];
                    }
                }
            }
        }

        int ans = 0;
        // return max in the last row
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ans = Math.max(ans , t[m - 1][i][j]);
            }
        }

        return ans;
    }
}