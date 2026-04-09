//Approach-1 (Using Recursion + Memoization)
//T.C : O(row*col*col * 9) -> 9 is from the double for loop for colDir
//S.C : O(row * col * col)
class Solution {
    int[][][] t;
    int m;
    int n;
    int[] colDir = {-1 , 0 , 1};

    boolean isSafe(int col){
        return col >= 0 && col < n;
    }

    public int solve(int[][] grid , int row , int col1 , int col2){
        if(row >= m){
            return 0;
        }

        if(t[row][col1][col2] != -1){
            return t[row][col1][col2];
        }

        int count = grid[row][col1];
        if(col1 != col2){ // as we can take a cell only once
            count += grid[row][col2];
        }
        
        int ans = Integer.MIN_VALUE;

        for(int x : colDir){
            for(int y : colDir){
                int newCol1 = col1 + x;
                int newCol2 = col2 + y;

                if(isSafe(newCol1) && isSafe(newCol2)){
                     ans = Math.max(ans , solve(grid , row + 1 , newCol1 , newCol2));
                }
            }
        }

        return t[row][col1][col2] = count + ans;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        t = new int[71][71][71];

        for (int i = 0; i < 71; i++) {
            for (int j = 0; j < 71; j++) {
                Arrays.fill(t[i][j], -1);
            }
        }

        return solve(grid, 0, 0, n - 1);
    }
}