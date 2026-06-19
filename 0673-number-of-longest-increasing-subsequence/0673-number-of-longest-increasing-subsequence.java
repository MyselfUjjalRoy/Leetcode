class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int[] count = new int[n];
        Arrays.fill(count , 1);

        int maxLen = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && dp[i] < 1 + dp[j]){
                    dp[i] = 1 + dp[j];
                    count[i] = count[j];
                    maxLen = Math.max(maxLen , dp[i]);
                }
                else if(nums[j] < nums[i] && dp[i] == 1 + dp[j]){
                    count[i] += count[j];
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == maxLen){
                ans += count[i];
            }
        }


        return ans;
    }
}