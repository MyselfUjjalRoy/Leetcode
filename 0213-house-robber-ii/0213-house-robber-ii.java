class Solution {
    // constant space

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int prevKaPrev = 0;
        int prev = 0;

        for(int i = 1; i <= n - 1; i++){
            int steal = nums[i - 1] + prevKaPrev;
            int skip = prev;

            int temp = Math.max(steal , skip);
            prevKaPrev = prev;
            prev = temp;
        }

        int result1 = prev;

        prevKaPrev = 0;
        prev = 0;
        for(int i = 2; i <= n; i++){
            int steal = nums[i - 1] + prevKaPrev;
            int skip = prev;

            int temp = Math.max(steal , skip);
            prevKaPrev = prev;
            prev = temp;
        }

        int result2 = prev;

        return Math.max(result1 , result2);
    }
}