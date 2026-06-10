class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];

        int count = 0;

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(i == j){
                    dp[i][j] = true;
                }
                else if(i + 1 == j){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] == true); 
                }

                if(dp[i][j] == true){
                    count++;
                }
            }
        }

        return count;
    }
}