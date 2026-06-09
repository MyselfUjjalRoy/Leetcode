class Solution {
    int n;
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        dp = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return LIS(-1 , 0 , nums); // [prevIdx , currIdx , nums]
    }

    public int LIS(int prevIdx , int currIdx , int[] nums){
        if(currIdx >= n){
            return 0;
        }

        if(prevIdx != -1 && dp[prevIdx][currIdx] != -1){
            return dp[prevIdx][currIdx];
        }

        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[currIdx]){
            take = 1 + LIS(currIdx , currIdx + 1 , nums);
        }

        int skip = LIS(prevIdx , currIdx + 1 , nums);

        int ans = Math.max(take , skip);

        if(prevIdx != -1){
            dp[prevIdx][currIdx] = ans;
        }

        return ans;
    }
}