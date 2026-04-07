class Solution {
    int[][][] t;
    int N;
    int thresholdProfit;
    int MOD = 1_000_000_007;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        N = n;
        t = new int[101][101][101];

        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                Arrays.fill(t[i][j] , -1);
            }
        }
        
        thresholdProfit = minProfit;

        return solve(0 , 0 , 0 , group , profit);
    }

    public int solve(int i , int p , int people , int[] group , int[] profit){
        if(people > N){
            return 0;
        }

        if(i == group.length){
            if(p >= thresholdProfit){
                return t[i][p][people] = 1;
            }
            else{
                return t[i][p][people] = 0;
            }
        }

        if(t[i][p][people] != -1){
            return t[i][p][people];
        }

        long skip = solve(i + 1 , p , people , group , profit) % MOD;
        long take = solve(i + 1 , Math.min(thresholdProfit , p + profit[i]) , people + group[i] , group , profit) % MOD;

        return t[i][p][people] = (int)(take + skip) % MOD;
    }
}