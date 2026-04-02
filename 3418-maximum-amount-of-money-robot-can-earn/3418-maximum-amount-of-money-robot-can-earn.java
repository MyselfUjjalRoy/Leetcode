class Solution {
    int m , n;
    int[][][] t;

    public int solve(int[][] coins , int i , int j , int neu){
        if(i == m - 1 && j == n - 1){
            if(coins[i][j] < 0 && neu > 0){
                return 0;
            }
            else{
                return coins[i][j];
            }
        }

        if(i >= m || j >= n){
            return Integer.MIN_VALUE;
        }

        if(t[i][j][neu] != Integer.MIN_VALUE){
            return t[i][j][neu];
        }

        // take the cell
        int take = coins[i][j] + Math.max(solve(coins , i + 1, j , neu) , solve(coins , i , j + 1 , neu));

        // skip the cell if possible
        int skip = Integer.MIN_VALUE;
        if(coins[i][j] < 0 && neu > 0){
            int skip_karke_down = solve(coins , i + 1, j , neu - 1);
            int skip_karke_right = solve(coins , i , j + 1 , neu - 1);
            skip = Math.max(skip_karke_down , skip_karke_right);
        }
        

        return t[i][j][neu] = Math.max(take , skip);
    }
    public int maximumAmount(int[][] coins) {
        m = coins.length;
        n = coins[0].length;

        t = new int[m + 1][n + 1][3];
        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                Arrays.fill(t[i][j] , Integer.MIN_VALUE);
            }
        }

        return solve(coins , 0 , 0 , 2);
    }
}