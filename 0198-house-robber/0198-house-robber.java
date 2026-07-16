class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int[] dp = new int[n];

        int prev2 = nums[0];
        int prev1 = Math.max(nums[0] , nums[1]);
        int curr = 0;

        for(int i = 2; i < n; i++){
            int steal = nums[i] + prev2;
            int skip = prev1;
            curr = Math.max(steal , skip);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}