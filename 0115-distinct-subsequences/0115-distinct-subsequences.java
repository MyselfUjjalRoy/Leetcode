class Solution {
    int[][] dp;

    public int solve(int i, int j, String s, String t) {
        if (j == 0) return 1;   // empty t
        if (i == 0) return 0;   // empty s but t not empty

        if (dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j] = solve(i - 1, j - 1, s, t) 
                     + solve(i - 1, j, s, t);
        } else {
            dp[i][j] = solve(i - 1, j, s, t);
        }

        return dp[i][j];
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(m, n, s, t);
    }
}