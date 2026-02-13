class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();//decreasing monotonic stack
        int min = nums[0];
        int n = nums.length;
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && nums[i] >= stack.peek()[0]){
                stack.pop();
            }
            if(!stack.isEmpty() && nums[i] > stack.peek()[1]){
                return true;
            }
            stack.push(new int[]{nums[i] , min});
            min = Math.min(min , nums[i]);
        }
        return false;
    }
}