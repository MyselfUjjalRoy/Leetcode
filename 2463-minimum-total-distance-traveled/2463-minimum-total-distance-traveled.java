class Solution {
    long[][] dp;
    int m , n;
    public long solve(int ri , int fi , List<Integer> robots , List<Integer> factory){
        if(ri >= m){
            return 0;
        }
        if(fi >= n){
            return (long)1e12;
        }

        if(dp[ri][fi] != -1){
            return dp[ri][fi];
        }

        long take = Math.abs(robots.get(ri) - factory.get(fi)) + solve(ri + 1 , fi + 1 , robots , factory);
        long skip = solve(ri , fi + 1 , robots , factory);

        return dp[ri][fi] = Math.min(take , skip);
    }

    public long minimumTotalDistance(List<Integer> robots, int[][] factory) {
        Collections.sort(robots);
        Arrays.sort(factory , (a , b)-> a[0] - b[0]);       

        List<Integer> positions = new ArrayList<>();

        for(int[] f : factory){
            int pos = f[0];
            int limit = f[1];

            for(int j = 0; j < limit; j++){
                positions.add(pos);
            }
        }

        m = robots.size();
        n = positions.size();

        dp = new long[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(0 , 0 , robots , positions);
    }
}