public class Solution {

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;

        List<int[]> list = new ArrayList<>();
        for (int num : nums) {
            list.add(new int[]{num, digitSum(num)});
        }

        list.sort((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });

        Map<Integer, Integer> targetPos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            targetPos.put(list.get(i)[0], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; ) {
            int correctIdx = targetPos.get(nums[i]);
            if (i == correctIdx) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[correctIdx];
                nums[correctIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }
}