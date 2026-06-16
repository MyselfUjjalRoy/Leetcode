class Solution {
    int n;
    int[][] dp;
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();

        n = s.length();
        
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(n , n , s , rev);
    }

    public int solve(int m , int n , String s1 , String s2){
        if(m <= 0 || n <= 0){
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