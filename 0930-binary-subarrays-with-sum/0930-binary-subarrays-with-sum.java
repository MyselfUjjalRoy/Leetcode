class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countLessOrEqual(nums , goal) - countLessOrEqual(nums , goal - 1);
    }
    public int countLessOrEqual(int[] nums , int target){
        if(target < 0) return 0;

        int n = nums.length;
        int left = 0;
        int right = 0;

        int count = 0;
        int sum = 0;

        while(right < n){
            sum += nums[right];

            while(sum > target){
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}