class Solution {
    int N , M , K;
    int[][][] dp;
    int MOD = (int)1e9 + 7;
    public int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;

        dp = new int[51][51][101];

        for(int i = 0; i < 51; i++){
            for(int j = 0; j < 51; j++){
                Arrays.fill(dp[i][j] , -1);
            }
        }

        return solve(0 , 0 , 0);
    }

    public int solve(int idx , int searchCost , int maxSoFar){
        if(idx == N){
            if(searchCost == K){
                return 1;
            }

            return 0;
        }

        if(dp[idx][searchCost][maxSoFar] != -1){
            return dp[idx][searchCost][maxSoFar];
        }

        long ans = 0;

        for(int i = 1; i <= M; i++){
            if(i > maxSoFar){
                ans = (ans + solve(idx + 1 , searchCost + 1 , i)) % MOD;
            }
            else{
                ans = (ans + solve(idx + 1 , searchCost , maxSoFar)) % MOD;
            }
        }

        return dp[idx][searchCost][maxSoFar] = (int)ans % MOD;
    }
}