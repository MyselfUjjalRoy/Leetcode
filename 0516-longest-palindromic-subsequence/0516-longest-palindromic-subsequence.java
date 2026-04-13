class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        //dp[i][j] -> lps of s[i ... j]

        for(int i = 0; i < n; i++){
            dp[i][i] = 1; // because all length 1 string is pallindrome
        }

        for(int len = 2; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}