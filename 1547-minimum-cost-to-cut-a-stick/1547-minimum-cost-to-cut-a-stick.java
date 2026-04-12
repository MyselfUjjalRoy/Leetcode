class Solution {
    // codestory with mik
    int[][] dp;

    public int solve(int left , int right , int[] cuts){
        if((right - left) == 1){
            return 0;
        }

        if(dp[left][right] != -1){
            return dp[left][right];
        }

        int ans = Integer.MAX_VALUE;
        for(int idx = left + 1; idx < right; idx++){
            int cost = (cuts[right] - cuts[left]) + solve(left , idx , cuts) + solve(idx , right , cuts);
            ans = Math.min(ans , cost);
        }

        return dp[left][right] = ans;
    }
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;

        for(int i = 0; i < m; i++){
            newCuts[i] = cuts[i];
        }

        Arrays.sort(newCuts);

        dp = new int[m + 2][m + 2];
        for(int i = 0; i < m + 2; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , m + 1 , newCuts);
    }
}