class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans , -1);

        for(int i = 2 * n - 1; i >= 0; i--){
            int val = nums[i % n];
            while(!stack.isEmpty() && stack.peek() <= val){
                stack.pop();
            }

            if(i < n && !stack.isEmpty()){
                ans[i] = stack.peek();
            }

            stack.push(val);
        }

        return ans;
    }
}