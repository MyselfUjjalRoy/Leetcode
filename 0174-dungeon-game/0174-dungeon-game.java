class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(i == m - 1 && j == n - 1){
                    if(dungeon[i][j] > 0){
                        dp[i][j] = 1;
                    }
                    else{
                        dp[i][j] = Math.abs(dungeon[i][j]) + 1;
                    }
                }
                else{
                    int right = (j + 1 >= n) ? Integer.MAX_VALUE : dp[i][j + 1];
                    int down = (i + 1 >= m) ? Integer.MAX_VALUE : dp[i + 1][j];

                    int res = Math.min(right , down) - dungeon[i][j];

                    dp[i][j] = res > 0 ? res : 1;
                }
            }
        }

        return dp[0][0];
    }
}