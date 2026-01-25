class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int minNum =Integer.MAX_VALUE;
        int i = 0;
        while(i<=n-k){
            int diff = nums[i+k-1] - nums[i];
            i++;
            minNum = Math.min(minNum , diff);
        }
        return minNum;
    }
}