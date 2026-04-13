class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = Math.max(text1.length() , text2.length());
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        //dp[i][j] -> lcs when s1 of length i , s2 of length j

        for(int i = 1; i < text1.length() + 1; i++){
            for(int j = 1; j < text2.length() + 1; j++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}