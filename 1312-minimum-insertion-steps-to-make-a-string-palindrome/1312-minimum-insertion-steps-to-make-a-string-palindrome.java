class Solution {
    public int minInsertions(String s) {
        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(i == j){
                    dp[i][j] = 0; // means no chars i need to insert
                }
                else if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j - 1];
                }
                else{
                    dp[i][j] = 1 + Math.min(dp[i + 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}