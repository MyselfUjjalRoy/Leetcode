class Solution {
    public int minOperations(int[] nums, int x) {
        int i = 0 , j = 0;
        int ans = -1;
        int n = nums.length;
        long sum = 0;
        long total = 0;
        for(int num : nums) total += num;
        while(j < n){
            sum += nums[j];
            while(i < j && sum > total - x){
                sum -= nums[i];
                i++;
            }
            if(sum == total - x){
                ans = Math.max(ans , j - i + 1);
            }
            j++;
        }
        return ans == -1 ? -1 : n - ans;
    }
}