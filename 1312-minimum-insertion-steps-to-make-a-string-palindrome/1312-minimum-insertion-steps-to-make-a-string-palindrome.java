class Solution {

    // tc : n^2
    // sc : n^ 2
    public int minInsertions(String s) {
        int n = s.length();
        int[][] t = new int[n][n];
        //t[i][j] = min insertions to make s[i .. j] a pallindrome

        for(int i = 0; i < n; i++){
            t[i][i] = 0;
        }

        for(int length = 2; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(s.charAt(i) == s.charAt(j)){
                    t[i][j] = t[i + 1][j - 1];
                }
                else{
                    t[i][j] = 1 + Math.min(t[i][j - 1] , t[i + 1][j]);
                }
            }
        }

        return t[0][n - 1];
    }
}