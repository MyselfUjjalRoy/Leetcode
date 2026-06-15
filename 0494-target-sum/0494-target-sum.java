class Solution {
    int[][] dp;
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        if((total - diff) % 2 != 0  || (total - diff) < 0) return 0;

        dp = new int[n][((total - diff) / 2) + 1];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(n - 1 , (total - diff) / 2 , nums);
    }

    public int solve(int idx , int target , int[] nums){
        if(idx == 0){
            if(nums[0] == 0 && target == 0){
                return 2;
            }
            else if(nums[0] == target || target == 0){
                return 1;
            }
            else return 0;
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int skip = solve(idx - 1 , target, nums);
        int take = 0;

        if(nums[idx] <= target){
            take = solve(idx - 1 , target - nums[idx], nums);
        }

        return dp[idx][target] = take + skip;
    }
}