class Solution {
    public void sortColors(int[] nums) {
        int left = 0 , mid = 0 , high = nums.length - 1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(left , mid , nums);
                left++;
                mid++;
            }
            else if(nums[mid] == 1){
                mid++;
            }
            else{
                swap(mid , high , nums);
                high--;
            }
        }
    }
    public void swap(int i1 , int i2 , int[] nums){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}