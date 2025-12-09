import java.util.*;

class Solution {
    public int specialTriplets(int[] nums) {
        int MOD = 1_000_000_007;
        long count = 0;

        Map<Integer, Integer> rightFreq = new HashMap<>();
        Map<Integer, Integer> leftFreq = new HashMap<>();

        // Count all frequencies first (initially all numbers are on the right)
        for (int num : nums) {
            rightFreq.put(num, rightFreq.getOrDefault(num, 0) + 1);
        }

        // Process each number
        for (int num : nums) {
            // Move current number from right to left
            rightFreq.put(num, rightFreq.get(num) - 1);

            int doubleNum = num * 2;
            long left = leftFreq.getOrDefault(doubleNum, 0);
            long right = rightFreq.getOrDefault(doubleNum, 0);

            count = (count + left * right) % MOD;

            // Add current number to left map
            leftFreq.put(num, leftFreq.getOrDefault(num, 0) + 1);
        }

        return (int) count;
    }
}
