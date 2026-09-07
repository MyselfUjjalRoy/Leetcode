class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        if(n == 1) return nums[0];

        int a = nums[0];
        int b = Math.max(nums[0] , nums[1]);
        int c = 0;

        for(int i = 2; i < n; i++){
            int steal = nums[i] + a;
            int skip = b;

            c = Math.max(steal , skip);
            a = b;
            b = c;
        }

        return b;
    }
}