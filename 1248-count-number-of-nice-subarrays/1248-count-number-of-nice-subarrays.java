class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums , k) - atMost(nums , k - 1);
    }

    public int atMost(int[] nums , int k){
        if(k < 0) return 0;

        int n = nums.length;
        int count = 0;
        int left = 0 , right = 0;
        int ans = 0;

        while(right < n){
            if(nums[right] % 2 == 1) count += 1;

            while(count > k){
                if(nums[left] % 2 == 1) count -= 1;
                left++;
            }

            ans += right - left + 1;
            right++;
        }

        return ans;
    }
}