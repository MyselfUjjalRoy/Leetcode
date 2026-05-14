class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++){
            if(nums[i] != i + 1) return false;
        }

        if(nums[n] != n) return false;


        return true;
    }
}