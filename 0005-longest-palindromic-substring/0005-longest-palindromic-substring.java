class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        
        int start = 0;
        int maxLength = 0;

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(i == j){ // length 1 
                    dp[i][j] = true;
                }
                else if(i + 1 == j){ // length 2
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && (dp[i + 1][j - 1] == true);
                }

                if(dp[i][j] == true && maxLength < length){
                    maxLength = length;
                    start = i;
                }
            }
        }

        return s.substring(start , start + maxLength);
    }
}