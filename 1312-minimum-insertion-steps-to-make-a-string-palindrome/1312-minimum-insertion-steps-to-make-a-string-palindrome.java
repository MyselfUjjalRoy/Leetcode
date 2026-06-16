class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        
        int[][] dp = new int[n][n];

        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;

                if(i == j){
                    dp[i][j] = 1;
                }
                else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = Math.max(dp[i + 1][j] , dp[i][j - 1]);
                }
            }
        }

        return n - dp[0][n - 1];
    }
}