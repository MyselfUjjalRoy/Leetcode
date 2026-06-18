class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(-1 , 0 , nums); // [prevIdx , currIdx , nums]
    }

    public int solve(int prevIdx , int currIdx , int[] nums){
        if(currIdx >= n) return 0;

        if(prevIdx != -1){
            if(dp[prevIdx][currIdx] != -1){
                return dp[prevIdx][currIdx];
            }
        }

        int take = 0;

        if(prevIdx == -1 || nums[prevIdx] < nums[currIdx]){
            take = 1 + solve(currIdx , currIdx + 1 , nums);
        }

        int skip = solve(prevIdx , currIdx + 1 , nums);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    }
}