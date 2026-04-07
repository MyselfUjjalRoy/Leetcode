class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;

        int i = 0;
        for(int j = 1; j < n; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}