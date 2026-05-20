class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;

        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        
        int count = 0;
        int prefixSum = 0;

        for(int right = 0; right < n; right++){
            prefixSum += nums[right];
            count += map.getOrDefault(prefixSum - goal , 0);

            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }

        return count;
    }
}