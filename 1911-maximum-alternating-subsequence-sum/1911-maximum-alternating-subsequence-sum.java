class Solution {
    // codestory with mik
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] t = new long[n][2];
        //t[i][0] -> length even (then -nums[i]), t[i][1] -> length odd(then +nums[i])

        t[0][0] = Math.max(-nums[0] , 0);
        t[0][1] = Math.max(nums[0] , 0);

        for(int i = 1; i < n; i++){
            // agar add kar ke length even ho toh (i - 1) tak odd ka max - nums[i]
            t[i][0] = Math.max(t[i - 1][1] - nums[i] , t[i - 1][0]);
            t[i][1] = Math.max(t[i - 1][0] + nums[i] , t[i - 1][1]);
        } 

        return Math.max(t[n - 1][0] , t[n - 1][1]);       
    }
}