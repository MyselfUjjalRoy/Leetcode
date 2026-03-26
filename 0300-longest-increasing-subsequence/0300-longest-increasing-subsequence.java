class Solution {
    int n;
    int[][] t;
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        t = new int[n + 1][n + 1];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(nums , -1 , 0); // {nums , prevIdx , currIdx}
    }

    public int solve(int[] nums , int prevIdx , int currIdx){
        if(currIdx >= n){
            return 0;
        }

        if(prevIdx != -1 && t[prevIdx][currIdx] != -1){
            return t[prevIdx][currIdx];
        }
        
        int take = 0;
        if(prevIdx == -1 || nums[prevIdx] < nums[currIdx]){
            take = 1 + solve(nums , currIdx , currIdx + 1);
        }

        int skip = solve(nums , prevIdx , currIdx + 1);

        if(prevIdx != -1){
           t[prevIdx][currIdx] = Math.max(take , skip);
        }

        return Math.max(take , skip);
    }
}