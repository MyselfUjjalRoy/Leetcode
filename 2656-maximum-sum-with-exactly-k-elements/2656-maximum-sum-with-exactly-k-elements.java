class Solution {
    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=nums[n-1];
        int temp=max-1;
        max=max+k-1;
        int sum=max*(max+1)/2;
        int prevSum=temp*(temp+1)/2;
        return sum-prevSum;
    }
}