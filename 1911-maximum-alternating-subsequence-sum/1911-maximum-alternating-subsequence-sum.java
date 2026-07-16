class Solution {
    long[][] dp;
    int n;
    public long solve(int idx , int[] nums , boolean flag){
        if(idx >= n) return 0;

        int f = flag ? 1 : 0;
        if(dp[idx][f] != -1) return dp[idx][f];

        long skip = solve(idx + 1 , nums , flag);
        
        int val = nums[idx];

        if(!flag) val = -val;

        long take = val + solve(idx + 1 , nums , !flag);

        return dp[idx][f] = Math.max(take ,skip);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;

        dp = new long[n + 1][2]; // 1 based indexing mei change kar liya
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , nums , true);
    }
}