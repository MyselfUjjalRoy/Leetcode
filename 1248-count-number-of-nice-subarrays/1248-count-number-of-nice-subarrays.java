class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);

        int prefixSum = 0;
        int count = 0;

        for(int right = 0; right < n; right++){
            prefixSum += (nums[right] % 2 == 1) ? 1 : 0;

            count += map.getOrDefault(prefixSum - k , 0);
            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        }

        return count;
    }
}