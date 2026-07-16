class Solution {
    int n;
    int[][] dp;
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;
        Arrays.sort(pairs , (a , b) -> a[0] - b[0]);
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(-1 , 0 , pairs);
    }

    public int solve(int prevIdx , int currIdx , int[][] pairs){
        if(currIdx >= n) return 0;

        if(prevIdx != -1 && dp[prevIdx][currIdx] != -1){
            return dp[prevIdx][currIdx];
        }

        int skip = solve(prevIdx , currIdx + 1 , pairs);
        
        int take = 0;
        if(prevIdx == -1 || pairs[prevIdx][1] < pairs[currIdx][0]){
            take = 1 + solve(currIdx , currIdx + 1 , pairs);
        }

        int ans = Math.max(take , skip);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = ans;
        }

        return ans;
    }
}