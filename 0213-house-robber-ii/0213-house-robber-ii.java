class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        if(n == 2) return Math.max(nums[0] , nums[1]);

        int[] dp = new int[n + 1];
        Arrays.fill(dp , -1);
        
        int take_0th_house = solve(0 , n - 2 , nums , dp);

        Arrays.fill(dp , -1);

        int take_1st_house = solve(1 , n - 1 , nums , dp);

        return Math.max(take_0th_house , take_1st_house);
    }

    public int solve(int i , int n , int[] nums , int[] dp){
        if(i > n){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(i + 2 , n ,  nums , dp);
        int skip = solve(i + 1 , n , nums , dp);

        return dp[i] = Math.max(steal , skip);
    }
}