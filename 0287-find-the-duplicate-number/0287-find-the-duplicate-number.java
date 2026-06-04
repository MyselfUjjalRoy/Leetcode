class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find cycle entrance
        int ptr = nums[0];

        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }

        return ptr;
    }
}