class Solution {
    // front partition
    // striver

    int[] dp;
    int n;
    public int solve(int idx , int[] arr , int k){
        if(idx == n) return 0;

        if(dp[idx] != -1){
            return dp[idx];
        }

        int len = 0;
        int maxElement = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;

        for(int j = idx; j < Math.min(idx + k , n); j++){
            len++;
            maxElement = Math.max(maxElement , arr[j]);

            int currSum = (maxElement * len) + solve(j + 1 , arr , k);

            sum = Math.max(sum , currSum);
        }

        return dp[idx] = sum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        n = arr.length;
        dp = new int[n];
        // dp[i] -> give me the max sum if we have the array starting from i

        Arrays.fill(dp , -1);

        return solve(0 , arr , k);
    }
}