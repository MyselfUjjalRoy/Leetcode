class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1) return nums[0];

        int[] dp = new int[n];

        int case1 = 0;
        int case2 = 0;

        int prev2 = 0;
        int prev1 = nums[0];

        for(int i = 1; i <= n - 2; i++){
            int curr = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        case1 = prev1;

        prev2 = 0;
        prev1 = nums[1];

        for(int i = 2; i <= n - 1; i++){
            int curr = Math.max(prev1 , prev2 + nums[i]);
            prev2 = prev1;
            prev1 = curr;
        }

        case2 = prev1;

        return Math.max(case1 , case2);
    }
}