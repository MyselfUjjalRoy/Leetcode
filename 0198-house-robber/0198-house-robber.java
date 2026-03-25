class Solution {
    /*
    bottom up appraoch - codestory with mik
    t[i] = max stolen money till i
    */
    public int rob(int[] nums) {
        int n = nums.length;
        int[] t = new int[n + 1];

        t[0] = 0; // no house : i = 0
        t[1] = nums[0]; // 1 house : i = 1

        for(int i = 2; i <= n; i++){
            int steal = nums[i - 1] + t[i - 2];
            int skip = t[i - 1];

            t[i] = Math.max(steal , skip);
        }

        return t[n];
    }
}