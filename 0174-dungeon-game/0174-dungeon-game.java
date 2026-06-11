class Solution {
    int m , n;
    int[][] dp;
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        dp = new int[201][201];
        for(int i = 0; i < 201; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 0 , dungeon);
    }

    public int solve(int i , int j , int[][] dungeon){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == m - 1 && j == n - 1){
            return dp[i][j] = dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
        }

        int down = solve(i + 1 , j , dungeon);
        int right = solve(i , j + 1 , dungeon);

        int res = Math.min(down , right) - dungeon[i][j];

        return dp[i][j] = res > 0 ? res : 1;
    }
}