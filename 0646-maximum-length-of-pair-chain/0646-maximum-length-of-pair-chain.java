class Solution {
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        Arrays.sort(pairs , (a , b) -> a[0] - b[0]);

        return solve(-1 , 0 , pairs);
    }

    public int solve(int prevIdx , int currIdx , int[][] pairs){
        if(currIdx >= n){
            return 0;
        }

        if(prevIdx != -1 && dp[prevIdx][currIdx] != -1){
            return dp[prevIdx][currIdx];
        }

        int take = 0;
        if(prevIdx == -1 || pairs[prevIdx][1] < pairs[currIdx][0]){
            take = 1 + solve(currIdx , currIdx + 1 , pairs);
        }

        int skip = solve(prevIdx , currIdx + 1 , pairs);

        int ans = Math.max(take , skip);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = ans;
        }

        return ans;
    }
}