class Solution {
    int m , n;
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(m , n , s1 , s2);
    }

    public int solve(int m , int n , String s1 , String s2){
        if(m < 1 || n < 1){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s1.charAt(m - 1) == s2.charAt(n - 1)){
            return dp[m][n] = 1 + solve(m - 1 , n - 1 , s1 , s2);
        }

        return dp[m][n] = Math.max(solve(m - 1 , n , s1 , s2) , solve(m , n - 1 , s1 , s2));
    }
}