class Solution {
//Approach-2 (Using Recursion and Memoization) - ACCEPTED
//T.C : O(m*n)
//S.C : O(m*n)
    int m , n;
    int[][] t;
    public int solve(int i , int j , int[][] dungeon){
        if(i >= m || j >= n){
            return Integer.MAX_VALUE;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        if(i == m - 1 && j == n - 1){
            return t[i][j] = (dungeon[i][j] > 0) ? 1 : Math.abs(dungeon[i][j]) + 1;
        }
        
        int down = solve(i + 1 , j , dungeon);
        int right = solve(i , j + 1 , dungeon);

        int res = Math.min(down , right) - dungeon[i][j];

        return t[i][j] = res > 0 ? res : 1;
    }
    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;

        t = new int[201][201];
        for(int i = 0; i < 201; i++){
            Arrays.fill(t[i] , -1);
        }

        return solve(0 , 0 , dungeon);
    }
}