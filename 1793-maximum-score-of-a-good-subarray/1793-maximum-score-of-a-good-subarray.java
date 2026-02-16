class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k , j = k;
        int n = nums.length;
        int currMin = nums[k];
        int ans = nums[k];
        while(i > 0 || j < n - 1){
            int leftValue = i > 0 ? nums[i - 1] : 0;
            int rightValue = j < n - 1 ? nums[j + 1] : 0;

            if(leftValue < rightValue){
                j++;
                currMin = Math.min(currMin , nums[j]);
            }
            else{
                i--;
                currMin = Math.min(currMin , nums[i]);
            }
            int len = (j - i + 1);
            ans = Math.max(ans , len * currMin);
            
        }
        return ans;
    }
}