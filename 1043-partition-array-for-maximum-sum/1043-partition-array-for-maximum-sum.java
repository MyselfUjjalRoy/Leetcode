class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];

        for (int idx = n - 1; idx >= 0; idx--) {
            int maxElement = Integer.MIN_VALUE;
            int len = 0;
            int ans = Integer.MIN_VALUE;

            for (int i = idx; i < Math.min(n, idx + k); i++) {
                len++;
                maxElement = Math.max(maxElement, arr[i]);
                ans = Math.max(ans, len * maxElement + dp[i + 1]);
            }

            dp[idx] = ans;
        }

        return dp[0];
    }
}