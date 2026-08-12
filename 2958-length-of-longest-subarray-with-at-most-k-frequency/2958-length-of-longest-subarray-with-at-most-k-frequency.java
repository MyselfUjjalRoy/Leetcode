class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        int n = nums.length;
        int culprit = 0;
        while(j < n){
            map.put(nums[j] , map.getOrDefault(nums[j] , 0) + 1);
           
            if(map.get(nums[j]) == k + 1){
                culprit++;
            }
            if(culprit > 0){
                map.put(nums[i] , map.get(nums[i]) - 1);
                if(map.get(nums[i]) == k){
                    culprit--;
                }
                i++;
            }
            if(culprit == 0){
                ans = Math.max(ans , j - i + 1);
            }
            j++;
        }
        return ans;
    }
}