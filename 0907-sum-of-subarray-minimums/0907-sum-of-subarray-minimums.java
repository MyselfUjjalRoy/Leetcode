class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)1e9 + 7;

        int n = arr.length;
        int[] nse = new int[n];
        int[] psee = new int[n];

        // find nse
        Stack<Integer> stack = new Stack<>();
        for(int i = n - 1; i >= 0; i--){
            int val = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] >= val){
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // find psee
        for(int i = 0; i < n; i++){
            int val = arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] > val){
                stack.pop();
            }

            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        long sum = 0;

        for(int i = 0; i < n; i++){
            int left = i - psee[i];
            int right = nse[i] - i;
            sum = (sum + (long)arr[i] * left * right) % MOD;
        }

        return (int)sum;
    }
}