class Solution {
    // Striver
    boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        //Arrays.fill(dp , -1);

        for (int i = n - 1; i >= 0; i--) {
            int ans = Integer.MAX_VALUE;
            String temp = "";

            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    ans = Math.min(ans, cost);
                }
            }
            dp[i] = ans;
        }

        return dp[0] - 1; // -1 because it is partitioning at the last 
    }
}