class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = i + j;
                }
                else{
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    else{
                        int insert = 1 + dp[i][j - 1];
                        int delete = 1 + dp[i - 1][j];
                        int replace = 1 + dp[i - 1][j - 1];

                        dp[i][j] = Math.min(insert , Math.min(delete , replace));
                    }
                }
            }
        }

        return dp[m][n];
    }
}