class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;

        for (int i = 1; i <= n; i++) {
            newNums[i] = nums[i - 1];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n + 1; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j)
                    continue;

                int ans = Integer.MIN_VALUE;

                for (int idx = i; idx <= j; idx++) {
                    int cost = newNums[i - 1] * newNums[idx] * newNums[j + 1] + dp[i][idx - 1]
                        + dp[idx + 1][j];

                    ans = Math.max(ans, cost);
                }
                dp[i][j] = ans;
            }
        }

        return dp[1][n];
    }
}