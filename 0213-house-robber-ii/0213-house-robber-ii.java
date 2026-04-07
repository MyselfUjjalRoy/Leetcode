class Solution {
    // ekbaar practice kar lete haiiii , revise ho jayega
    /*
    at first i will start robbing the houses from 0 to n - 2 because the houses are circular so i can't rob the last house 
    then secondly i will again start robbing houses from 1 to n - 1 
    - and between these two whatever maximum value i get , i will return that value

    - this is the same question as house robber , so i will just use the function and call two times
      and return the answer , that't it you are good to go

    */
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp , -1);

        int startFrom_0 = solve(0 , n - 2 , nums);
        Arrays.fill(dp , - 1);

        int startFrom_1 = solve(1 , n - 1 , nums);

        return Math.max(startFrom_0 , startFrom_1);
    }

    public int solve(int i , int n , int[] nums){
        if(i > n){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        int take = nums[i] + solve(i + 2 , n , nums);
        int skip = solve(i + 1 , n , nums);

        return dp[i] = Math.max(take , skip);
    }
}