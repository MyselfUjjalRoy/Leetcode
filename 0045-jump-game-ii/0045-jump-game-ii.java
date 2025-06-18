//from striver
class Solution {
    public int jump(int[] nums) {
        int l = 0 , r = 0;
        int n = nums.length;
        int jumps = 0;

        while(r < n - 1){
            int farthest = 0;
            for(int index = l; index <= r; index++){
                farthest = Math.max(farthest , index + nums[index]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }
}