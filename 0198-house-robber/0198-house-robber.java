class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int prev_ka_prev= 0;
        int prev = nums[0];

        for(int i = 2; i <= n; i++){
            int steal = nums[i - 1] + prev_ka_prev;
            int skip = prev;

            int temp = Math.max(steal , skip);
            prev_ka_prev = prev;
            prev = temp;
        }

        return prev;
    }
}