class Solution {
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }
        
        if((total - diff) % 2 != 0  || (total - diff) < 0) return 0;

        int target = (total - diff) / 2;

        int[][] dp = new int[n][target + 1];

        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
            if(nums[0] <= target){
                dp[0][nums[0]] = 1;
            }
        }

        for(int i = 1; i < n; i++){
            for(int t = 0; t <= target; t++){
                int skip = dp[i - 1][t];
                int take = 0;
                if(nums[i] <= t){
                    take = dp[i - 1][t - nums[i]];
                }

                dp[i][t] = take + skip;
            }
        }

        return dp[n - 1][target];
    }
}