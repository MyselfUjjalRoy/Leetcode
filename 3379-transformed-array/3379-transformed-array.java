class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                ans[i] = 0;
            }
            else if(nums[i] < 0){
                int index = Math.abs((i + nums[i] + n) % n);
                ans[i] = nums[index];
            }
            else{
                int index = (i + nums[i]) % n;
                ans[i] = nums[index];
            }
        }
        return ans;
    }
}