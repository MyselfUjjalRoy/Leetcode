class Solution {
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;

        int[] newCuts = new int[len + 2];
        newCuts[0] = 0;
        for (int i = 1; i < len + 1; i++) {
            newCuts[i] = cuts[i - 1];
        }
        newCuts[len + 1] = n;

        Arrays.sort(newCuts);

        int[][] dp = new int[len + 2][len + 2];

        for (int i = len; i >= 1; i--) {
            for (int j = 1; j <= len; j++) {

                if(i > j) continue;

                int mini = Integer.MAX_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = newCuts[j + 1] - newCuts[i - 1] + dp[i][k - 1] + dp[k + 1][j];

                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][len];
    }
}