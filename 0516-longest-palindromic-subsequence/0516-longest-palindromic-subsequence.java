class Solution {
    int[][] dp;
    public int solve(int i , int j , String s){
        if(i > j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(i == j){
            return 1;
        }
        else if(s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2 + solve(i + 1 , j - 1 , s);
        }
        else{
            dp[i][j] = Math.max(solve(i + 1 , j , s) , solve(i , j - 1 , s));
        }

        return dp[i][j];

    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , n - 1 , s);
    }
}