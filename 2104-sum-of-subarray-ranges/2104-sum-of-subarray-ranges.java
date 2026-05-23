class Solution {
    public long sumSubArrayMin(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        int[] psee = new int[n];

        long sum = 0;
        Stack<Integer> stack = new Stack<>();

        //find nse
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] >= nums[i]){
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        //find psee
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]){
                stack.pop();
            }

            psee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(psee));

        for(int i = 0; i < n; i++){
            long left = i - psee[i];
            long right = nse[i] - i;
            sum = sum + nums[i] * left * right;
        }

        return sum;
    }
    public long sumSubArrayMax(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        int[] pgee = new int[n];

        Stack<Integer> stack = new Stack<>();

        // find next Greater
        for(int i = n - 1; i >= 0; i--){
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]){
                stack.pop();
            }

            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // find pgee
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                stack.pop();
            }

            pgee[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        System.out.println(Arrays.toString(nge));
        System.out.println(Arrays.toString(pgee));

        long sum = 0;

        for(int i = 0; i < n; i++){
            long left = i - pgee[i];
            long right = nge[i] - i;
            sum = sum + nums[i] * left * right;
        }

        return sum;
    }
    public long subArrayRanges(int[] nums) {
        return sumSubArrayMax(nums) - sumSubArrayMin(nums);
    }
}