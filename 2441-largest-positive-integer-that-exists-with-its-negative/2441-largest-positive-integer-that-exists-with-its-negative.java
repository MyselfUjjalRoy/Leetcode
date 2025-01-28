class Solution {
    public int findMaxK(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int left=0;
        int right=n-1;
        while(left<right){
            if((-1)*nums[left]==nums[right])
            {
                return nums[right];
            }
            else if((-1)*nums[left]>nums[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return -1;
    }
}