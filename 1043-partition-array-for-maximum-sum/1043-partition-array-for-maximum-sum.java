class Solution {
    int n;
    int[] dp;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n];
        // dp[i] -> give me the max sum if we have the array starting from i
        Arrays.fill(dp , -1);

        return solve(0 , k , arr);
    }
    public int solve(int idx , int k , int[] arr){
        if(idx == n){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int maxElement = Integer.MIN_VALUE;
        int len = 0;
        int ans = Integer.MIN_VALUE;

        for(int i = idx; i < Math.min(n , idx + k); i++){
            len++;
            maxElement = Math.max(maxElement , arr[i]);
            ans = Math.max(ans , len * maxElement + solve(i + 1 , k , arr));
        }

        return dp[idx] = ans;
    }
}