class Solution {
    // front partition
    // striver

    // bottom up

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        // dp[i] -> give me the max sum if we have the array starting from i

        for (int idx = n - 1; idx >= 0; idx--) {
            int len = 0;
            int maxElement = Integer.MIN_VALUE;
            int sum = Integer.MIN_VALUE;

            for (int j = idx; j < Math.min(idx + k, n); j++) {
                len++;
                maxElement = Math.max(maxElement, arr[j]);

                int currSum = (maxElement * len) + dp[j + 1];

                sum = Math.max(sum, currSum);
            }

            dp[idx] = sum;
        }

        return dp[0];
    }
}