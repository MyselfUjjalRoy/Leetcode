class Solution {
    long[][] dp;
    int n;
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        dp = new long[n][2];

        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , true , nums);
    }

    public long solve(int idx , boolean flag , int[] nums){
        if(idx >= n) return 0;

        int f = flag ? 1 : 0;

        if(dp[idx][f] != -1) return dp[idx][f];

        long skip = solve(idx + 1 , flag , nums);

        long val = nums[idx];

        if(!flag){
            val = -val;
        }

        long take = solve(idx + 1 , !flag , nums) + val;

        return dp[idx][f] = Math.max(take , skip);
    }
}