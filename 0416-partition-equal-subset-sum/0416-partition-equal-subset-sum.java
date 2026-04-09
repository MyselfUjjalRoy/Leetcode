class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int num : nums){
            total += num;
        }

        if(total % 2 != 0){
            return false;
        }

        int target = total / 2;
        dp = new Boolean[n][target + 1];
        
        return solve(nums , target , n - 1);
    }

    public boolean solve(int[] nums , int target , int idx){
        if(target == 0) return true;
        if(idx == 0) return nums[idx] == target;

        if(dp[idx][target] != null){
            return dp[idx][target];
        }

        boolean skip = solve(nums , target , idx - 1);
        boolean take = false;

        if(nums[idx] <= target){
            take = solve(nums , target - nums[idx] , idx - 1);
        }

        return dp[idx][target] = take || skip;
    }
}