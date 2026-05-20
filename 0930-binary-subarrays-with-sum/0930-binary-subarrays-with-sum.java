class Solution { // works only for non negative numbers
    public int numSubarraysWithSum(int[] nums, int goal) {
        return sumLessThanEqualsToGoal(nums , goal) - sumLessThanEqualsToGoal(nums , goal - 1);
    }
    public int sumLessThanEqualsToGoal(int[] nums , int goal){
        if(goal < 0) return 0;

        int n = nums.length;
        int left = 0 , right = 0;
        int count = 0;
        int sum = 0;

        while(right < n){
            sum += nums[right];
            
            while(sum > goal){
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}