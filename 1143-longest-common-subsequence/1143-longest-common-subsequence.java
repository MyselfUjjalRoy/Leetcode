class Solution {
    int m , n;
    int[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        m = s1.length();
        n = s2.length();

        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(m - 1 , n - 1 , s1 , s2);
    }

    public int solve(int i , int j , String s1 , String s2){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(i - 1 , j - 1 , s1 , s2);
        }
        
        return dp[i][j] = Math.max(solve(i - 1 , j , s1 , s2) , solve(i , j - 1 , s1 , s2));
    }
}