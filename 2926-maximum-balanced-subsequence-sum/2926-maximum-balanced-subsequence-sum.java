class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                ans = Math.max(ans, nums[i]);
            } else {

                int key = nums[i] - i;

                Integer floorKey = map.floorKey(key);
                long currSum = nums[i];
                if (floorKey != null) {
                    currSum += map.get(floorKey);
                }

                map.put(key, Math.max(map.getOrDefault(key, Long.MIN_VALUE), currSum));

                Integer higherKey = map.higherKey(key);
                while (higherKey != null && map.get(higherKey) <= currSum) {
                    map.remove(higherKey);
                    higherKey = map.higherKey(key);
                }

                ans = Math.max(ans, currSum);
            }
        }

        return ans;
    }
}