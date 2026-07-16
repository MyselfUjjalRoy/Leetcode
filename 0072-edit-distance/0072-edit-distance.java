class Solution {
    int m , n;
    int[][] dp;
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(word1 , word2 , m , n);
    }

    public int solve(String word1 , String word2 , int i , int j){
        if(i == 0 || j == 0){
            return i + j;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
            dp[i][j] = solve(word1 , word2 , i - 1 , j - 1);
        }
        else{
            int delete = 1 + solve(word1 , word2 , i - 1 , j);
            int insert = 1 + solve(word1 , word2 , i , j - 1);
            int update = 1 + solve(word1 , word2 , i - 1 , j - 1);

            dp[i][j] = Math.min(insert , Math.min(delete , update));
        }

        return dp[i][j];
    }
}