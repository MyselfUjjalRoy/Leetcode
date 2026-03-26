class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLis = 1;
        int n = nums.length;
        int[] t = new int[n]; // which refers max length of LIS till i
        Arrays.fill(t , 1);
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    t[i] = Math.max(t[i] , 1 + t[j]);
                    maxLis = Math.max(maxLis , t[i]);
                }
            }
        }
        return maxLis;
    }
}