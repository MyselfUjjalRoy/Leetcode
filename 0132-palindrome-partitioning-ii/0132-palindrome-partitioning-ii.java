class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];

        for(int length = 1; length <= n; length++){
            for(int i = 0; i + length - 1 < n; i++){
                int j = i + length - 1;

                if(i == j){ // length = 1
                    dp[i][j] = true;
                }
                else if(i + 1 == j){
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }
                else{
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] == true));
                }
            }
        }

        int[] cuts = new int[n];
        Arrays.fill(cuts , Integer.MAX_VALUE);

        for(int i = 0; i < n; i++){
            if(dp[0][i]){
                cuts[i] = 0;
            }
            else{
                for(int k = 0; k < i; k++){
                    if(dp[k + 1][i] == true && 1 + cuts[k] < cuts[i]){
                        cuts[i] = 1 + cuts[k];
                    }
                }
            }
        }

        return cuts[n - 1];
    }
}