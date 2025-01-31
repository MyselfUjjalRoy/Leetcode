class Solution {
    public int maximizeSum(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        int maxSum=0;
        for(int i=0;i<k;i++){
            maxSum+=max;
            max++;
        }
        return maxSum;
    }
}