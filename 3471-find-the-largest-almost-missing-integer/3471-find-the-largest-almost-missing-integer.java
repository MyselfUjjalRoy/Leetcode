class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Map<Integer, Boolean> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                if (!map.containsKey(nums[j])) {
                    count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
                    map.put(nums[j], true);
                }
            }
        }

        int max = -1;
        for (int num : count.keySet()) {
            if (count.get(num) == 1) {
                max = Math.max(max, num);
            }
        }

        return max;
    }
    
}