class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int num = nums[i];
            int digitSum = 0;
            while(num != 0){
                digitSum += num % 10;
                num /= 10;
            }
            min = Math.min(digitSum , min);
        }

        return min;
    }
}