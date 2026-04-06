
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);

        // dp[i][t] => max value till 0 ... i and time is j currently
        long[][] dp = new long[501][501];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , Integer.MIN_VALUE);
        }
        
        // at time 0, we have no value. i.e. 0 - COOKING NOT YET STARTED
        for (int i = 0; i < 501; i++) {
            dp[i][0] = 0;
        }

        dp[0][1] = satisfaction[0] * 1;

        for (int i = 1; i < n; i++) {
            for (int t = 1; t <= n; t++) {
                long include = satisfaction[i] * t + dp[i - 1][t - 1];
                long exclude = 0 + dp[i - 1][t];

                dp[i][t] = Math.max(include, exclude);
            }
        }

        //Since the Qn doesn't ask the maximum value at time = n, but
        //it asks for the maximum value overall at any time. 
        //So, we check the values for all time for 0....n-1 food i.e. last row depicts 0...n-1 (t[n-1
        long ans = 0;
        for (int time = 0; time <= n; time++) {
            ans = Math.max(ans, dp[n - 1][time]);
        }

        return (int) ans;
    }
}