class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int left = 0, right =0;
        long count = 0;
        long sum = 0;
        while(left < n){
            while(right < n && (sum + nums[right])*(right - left +1) < k){
                sum += nums[right++];
            }
            count += right - left;
            if(right == left){
                right++;
            }
            else{
                sum -= nums[left];
            }
            left++;
        }
        return count;
    }
}