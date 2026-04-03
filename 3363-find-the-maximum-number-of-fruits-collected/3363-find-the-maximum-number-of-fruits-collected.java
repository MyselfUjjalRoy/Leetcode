class Solution {
    int[][] t;
    int n;
    public int child1Collect(int[][] grid){
        int score = 0;
        for(int i = 0; i < n; i++){
            score += grid[i][i];
            grid[i][i] = 0;
           // t[i][i] = 0;
        }

        return score;
    }

    public int child2Collect(int i , int j , int[][] grid){
        if(i >= n || j < 0 || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0; // already collected by child 1
        }

        // can't go beyond diagonal or left to diagonal (as we have only n - 1 moves)
        if(i == j || i > j){
            return 0;
        }
        
        if(t[i][j] != -1){
            return t[i][j];
        }

        int leftCorner = grid[i][j] + child2Collect(i + 1 , j - 1 , grid);
        int middle = grid[i][j] + child2Collect(i + 1 , j , grid);
        int rightCorner = grid[i][j] + child2Collect(i + 1 , j + 1 , grid);

        return t[i][j] = Math.max(leftCorner , Math.max(middle , rightCorner));

    }

    public int child3Collect(int i , int j , int[][] grid){
        if(i < 0 || i >= n || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0;
        }

        // can't go beyond diagonal or right to diagonal(as we have only n - 1 moves)
        if(i == j || j > i){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        int topCorner = grid[i][j] + child3Collect(i - 1 , j + 1 , grid);
        int right = grid[i][j] + child3Collect(i , j + 1 , grid);
        int rightCorner = grid[i][j] + child3Collect(i + 1 , j + 1 , grid);

        return t[i][j] = Math.max(topCorner , Math.max(right , rightCorner));
    }
    public int maxCollectedFruits(int[][] grid) {
        n = grid.length;
        t = new int[n][n];

        for(int[] row : t){
            Arrays.fill(row , -1);
        }

        // first child
        int firstChildScore = child1Collect(grid);

        // second child
        int secondChildScore = child2Collect(0 , n - 1 , grid);

        // third child
        int thirdChildScore = child3Collect(n - 1 , 0 , grid);

        return firstChildScore + secondChildScore + thirdChildScore;
    }
}