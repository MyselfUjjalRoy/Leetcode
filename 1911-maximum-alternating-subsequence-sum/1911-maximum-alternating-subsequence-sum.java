class Solution {
    // CodestoryWithMik

    int n;
    long[][] t = new long[100001][2];

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(0 , nums , true); // flag true -> '+' , false -> '-'
    }

    public long solve(int idx , int[] nums , boolean flag){
        if(idx >= n){
            return 0;
        }

        int f = flag ? 1 : 0;

        if(t[idx][f] != -1){
            return t[idx][f];
        }

        long skip = solve(idx + 1 , nums , flag); // when skipping the flag will be same

        long val = nums[idx];
        if(!flag){
            val = -val;
        }

        long take = solve(idx + 1 , nums , !flag) + val; // here falg will be altered

        return t[idx][f] = Math.max(skip , take);
    }
}