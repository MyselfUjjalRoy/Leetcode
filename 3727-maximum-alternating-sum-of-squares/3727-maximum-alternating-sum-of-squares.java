class Solution {
    public long maxAlternatingSum(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        Deque<Integer> dq= new ArrayDeque<>();
        for(int num : nums){
            dq.addLast(num);
        }
        long sum = 0;
        boolean turn = true;
        while(!dq.isEmpty()){
            if(turn){
                int val = dq.pollLast();
                sum += val * val;
                turn = false;
            }
            else{
                int val = dq.pollFirst();
                sum -= val * val;
                turn = true;
            }
        }
        return sum;
    }
}