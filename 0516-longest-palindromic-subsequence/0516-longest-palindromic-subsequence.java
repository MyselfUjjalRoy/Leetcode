class Solution {
    // solving using khandani template
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        
        int[][] t = new int[n][n];
        // t[i][j] = LPS in s[i ...j]

        for(int i = 0; i < n; i++){
            t[i][i] = 1; // 1 length is always pallindrome
        }

        for(int length = 2; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(s.charAt(i) == s.charAt(j)){
                    t[i][j] = 2 + t[i + 1][j - 1];
                }
                else{
                    t[i][j] = Math.max(t[i + 1][j] , t[i][j - 1]);
                }
            }
        }

        return t[0][n - 1]; // LPS of the whole string s[0... n - 1]
    }
}