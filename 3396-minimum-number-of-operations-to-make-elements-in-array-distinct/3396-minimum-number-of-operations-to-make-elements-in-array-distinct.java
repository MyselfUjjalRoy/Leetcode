class Solution {
    public int minimumOperations(int[] nums) {
        int[] hash = new int[101];
        int lastIndex = 0;
        int n = nums.length;

        // Step 1: Go backwards and find where the first duplicate shows up
        for (int i = n - 1; i >= 0; i--) {
            hash[nums[i]]++;
            if (hash[nums[i]] > 1) {
                lastIndex = i + 1; // number of elements we need to consider removing
                break;
            }
        }

        // Step 2: Calculate how many operations of 3 we need
        if (lastIndex % 3 == 0) return lastIndex / 3;
        return lastIndex / 3 + 1;
    }
}