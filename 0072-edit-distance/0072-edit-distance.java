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

    public int solve(String word1 , String word2 , int m , int n){
        if(m == 0 || n == 0){
            return m + n;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(word1.charAt(m - 1) == word2.charAt(n - 1)){
            return dp[m][n] = solve(word1 , word2 , m - 1 , n - 1);
        }
        else{
            int insert = 1 + solve(word1 , word2 , m , n - 1);
            int delete = 1 + solve(word1 , word2 , m - 1 , n);
            int replace = 1 + solve(word1 , word2 , m - 1 , n - 1);

            return dp[m][n] = Math.min(insert , Math.min(delete , replace));
        }
    }
}