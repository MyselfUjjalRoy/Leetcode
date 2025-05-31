class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, zerosFlipped = 0, ans = 0;
        for(int end = 0; end < nums.length; end++){
            if(nums[end] == 0){
                zerosFlipped++;
            }
           
            while(zerosFlipped > k){
                if(nums[start] == 0){
                    zerosFlipped--;
                }
                start++;
            }
            ans = Math.max(ans , end - start + 1);
        }
        return ans;
    }
}