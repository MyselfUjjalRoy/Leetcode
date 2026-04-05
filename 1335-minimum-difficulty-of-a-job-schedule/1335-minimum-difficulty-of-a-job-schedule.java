class Solution {
    int[][] t;
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        
        if(n < d){
            return -1; // because no day should be empty
        }

        t = new int[n][d + 1];
        for(int[] row : t){
            Arrays.fill(row , -1);
        }

        return solve(jobDifficulty , n , 0 , d);
    }

    public int solve(int[] jobDifficulty , int n , int idx , int d){
        /*
        base case :- if i have only 1 day , then i need to do all the remaining jobs 
        - so i need to select the max difficulty as the answer
        */
        if(d == 1){
            return Arrays.stream(Arrays.copyOfRange(jobDifficulty , idx , n)).max().orElse(Integer.MIN_VALUE);
        }

        if(t[idx][d] != -1){
            return t[idx][d];
        }

        int maxDifficulty = jobDifficulty[idx];
        int result = Integer.MAX_VALUE;

        /*
        try one by one with all possibilities
        take 1 job in one day , take 2 jobs in 2 day , take 3 jobs in one day and so  on ...
        - then find the optimal one among all the answers
        */

        for(int i = idx; i <= n - d; i++){
            maxDifficulty = Math.max(maxDifficulty , jobDifficulty[i]);
            result = Math.min(result , maxDifficulty + solve(jobDifficulty , n , i + 1 , d - 1));
        }

        return t[idx][d] = result;
    }
}