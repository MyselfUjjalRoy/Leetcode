class Solution {
    int m, n;
    int[][] dp;

    public int numDistinct(String s, String t) {
        m = s.length();
        n = t.length();

        dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        // find first n chars of t , in first m chars of s
        return solve(m, n, s, t);
    }

    public int solve(int m, int n, String s, String t) {
        if (n == 0)
            return 1; // t is fully matched
        if (m == 0)
            return 0; // s exhausted but t not matched

        if (dp[m][n] != -1) {
            return dp[m][n];
        }

        if (s.charAt(m - 1) == t.charAt(n - 1)) {
            return dp[m][n] = solve(m - 1, n - 1, s, t) + solve(m - 1, n, s, t);
        } else {
            return dp[m][n] = solve(m - 1, n, s, t);
        }
    }
}