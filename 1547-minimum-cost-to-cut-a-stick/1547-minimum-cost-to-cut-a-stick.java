class Solution { // Striver 
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        int len = cuts.length;
        int[] newCuts = new int[len + 2];
        newCuts[0] = 0;
        for(int i = 1; i < len + 1; i++){
            newCuts[i] = cuts[i - 1];
        }
        newCuts[len + 1] = n;

        Arrays.sort(newCuts);

        dp = new int[len + 1][len + 1];
        for(int i = 0; i < len + 1; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(1 , len , newCuts);
    }

    public int solve(int i , int j , int[] newCuts){
        if(i > j) return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int mini = Integer.MAX_VALUE;
        for(int k = i; k <= j; k++){
            int cost = newCuts[j + 1] - newCuts[i - 1] + solve(i , k - 1 , newCuts) + solve(k + 1 , j , newCuts);

            mini = Math.min(mini , cost);
        }

        return dp[i][j] = mini;
    }
}