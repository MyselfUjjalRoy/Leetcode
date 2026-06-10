class Solution {
    int[][] dp;
    int n;
    public int longestPalindromeSubseq(String s) {
        n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return LCS(s , rev , 0 , 0);
    }

    public int LCS(String s1, String s2 , int i , int j){
        if(i >= n || j >= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + LCS(s1 , s2 , i + 1 , j + 1);
        }

        return dp[i][j] = Math.max(LCS(s1 , s2 , i + 1 , j) , LCS(s1 , s2 , i , j + 1));
    }
}