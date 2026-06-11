class Solution {
    int n;
    int[][] dp;

    public int child1_Collect(int[][] fruits){
        int score = 0;
        for(int i = 0; i < n; i++){
            score += fruits[i][i];
            //fruits[i][i] = 0;
        }

        return score;
    }

    public int child2_Collect(int i , int j , int[][] fruits){
        if(i >= n || j < 0 || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0; // already collected by child 1
        }

        if(i == j || i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int leftCorner = fruits[i][j] + child2_Collect(i + 1 , j - 1 , fruits);
        int down = fruits[i][j] + child2_Collect(i + 1 , j , fruits);
        int rightCorner = fruits[i][j] + child2_Collect(i + 1 , j + 1 , fruits);

        return dp[i][j] = Math.max(leftCorner , Math.max(down , rightCorner));
    }

    public int child3_Collect(int i , int j , int[][] fruits){
        if(i >= n || i < 0  || j >= n){
            return 0;
        }

        if(i == n - 1 && j == n - 1){
            return 0; // already collected by child 1
        }

        if(i == j || j > i){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int topCorner = fruits[i][j] + child3_Collect(i - 1 , j + 1 , fruits);
        int right = fruits[i][j] + child3_Collect(i , j + 1 , fruits);
        int rightCorner = fruits[i][j] + child3_Collect(i + 1 , j + 1 , fruits);

        return dp[i][j] = Math.max(topCorner , Math.max(right , rightCorner));
    }


    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        // first child
        int firstChildScore = child1_Collect(fruits);

        // second child
        int secondChildScore = child2_Collect(0 , n - 1 , fruits);

        // third child

        int thirdChildScore = child3_Collect(n - 1 , 0 , fruits);

        return firstChildScore + secondChildScore + thirdChildScore;
    }
}