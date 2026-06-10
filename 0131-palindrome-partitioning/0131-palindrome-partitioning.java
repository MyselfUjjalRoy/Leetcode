class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();

        boolean[][] dp = new boolean[n + 1][n + 1];
        // dp[i][j] -> true : s[i ... j] is pallindrome

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i + length - 1 < n; i++) {
                int j = i + length - 1;
                if (i == j) { // length 1
                    dp[i][j] = true;
                } else if (i + 1 == j) { // length 2
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();
        List<String> currPartition = new ArrayList<>();

        solve(0, s, dp, currPartition, ans);

        return ans;
    }

    public void solve(int i, String s, boolean[][] dp, List<String> currPartition, List<List<String>> ans) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(currPartition));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (dp[i][j] == true) { // means pallindrome
                currPartition.add(s.substring(i, j + 1));
                solve(j + 1, s, dp, currPartition, ans);

                currPartition.remove(currPartition.size() - 1);
            }
        }
    }
}