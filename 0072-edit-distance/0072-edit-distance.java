class Solution {
    int m, n;
    int[][] dp;

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(m , n , word1 , word2);
    }

    public int solve(int i , int j , String word1 , String word2){
        if(i == 0 || j == 0) return i + j;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(word1.charAt(i - 1) == word2.charAt(j - 1)){
           return dp[i][j] = solve(i - 1 , j - 1 , word1 , word2);
        }
        else{
            int insert = 1 + solve(i , j - 1 , word1 , word2);
            int delete = 1 + solve(i - 1 , j , word1 , word2);
            int replace = 1 + solve(i - 1 , j - 1 , word1 , word2);

            return dp[i][j] = Math.min(insert , Math.min(delete , replace));
        }
    }
}