class Solution {
    public int isValid(int[] nums, int dir, int curr) {
        int n = nums.length;
        while(curr >= 0 && curr < n) {
            if(nums[curr] == 0) {
                curr += dir;
            } else {
                nums[curr]--;
                dir = -dir;
                curr += dir;
            }
        }
        for(int num : nums) {
            if(num != 0) return 0;
        }
        return 1;
    }

    public int countValidSelections(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] != 0) continue;

            int[] copy1 = nums.clone();
            int[] copy2 = nums.clone();

            count += isValid(copy1, 1, i);
            count += isValid(copy2, -1, i);
        }
        return count;
    }
}
