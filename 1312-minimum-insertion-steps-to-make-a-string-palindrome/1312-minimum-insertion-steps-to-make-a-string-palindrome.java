class Solution {
    int n;
    int[][] dp;

    public int minInsertions(String s) {
       n = s.length();
       dp = new int[n + 1][n + 1];
       for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
       }

       return solve(s , 0 , n - 1);
    }

    public int solve(String s, int i , int j){
        if(i >= j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = solve(s , i + 1 , j - 1);
        }

        return dp[i][j] = 1 + Math.min(solve(s , i + 1 , j) , solve(s , i , j - 1));
    }
}