class Solution {
    int n;
    Boolean[][] dp;

    public Boolean solve(int n , int sum , int[] nums){
        if(n == 0){
            return sum == 0;
        }
        if(sum == 0){
            return true;
        }

        if(dp[n][sum] != null){
            return dp[n][sum];
        }

        Boolean skip = solve(n - 1 , sum , nums);
        Boolean take = false;

        if(nums[n - 1] <= sum){
            take = solve(n - 1 , sum - nums[n - 1] , nums);
        }

        dp[n][sum] = take || skip;

        return dp[n][sum];
    }
    public boolean canPartition(int[] nums) {
        n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        int target = sum / 2;

        if(sum % 2 != 0) return false;

        dp = new Boolean[n + 1][target + 1];

        return solve(n , target , nums);
    }
}