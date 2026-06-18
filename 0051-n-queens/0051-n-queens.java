class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(char[] row : grid){
            Arrays.fill(row , '.');
        }
        solve(0 , grid , ans , n);
        return ans;
    }
    public void solve(int row , char[][] grid , List<List<String>> ans , int n){
        if(row == n){
            ans.add(construct(grid));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(grid , row , col , n)){
                grid[row][col] = 'Q';
                solve(row + 1 , grid , ans , n);
                grid[row][col] = '.';
            }
        }
    }
    public boolean isValid(char[][] grid , int row , int col , int n){
        int dupRow = row;
        int dupCol = col;
        while(row >= 0 && col >= 0){
            if(grid[row][col] == 'Q'){
                return false;
            }
            row--;
            col--;
        }
        row = dupRow;
        col = dupCol;
        while(row >= 0){
            if(grid[row][col] == 'Q'){
                return false;
            }
            row--;
        }
        row = dupRow;
        col = dupCol;
        while(row >=0 && col < n){
            if(grid[row][col] == 'Q'){
                return false;
            }
            row--;
            col++;
        }
        return true;
    }
    public List<String> construct(char[][] grid){
        List<String> res = new ArrayList<>();
        for(char[] row : grid){
            res.add(new String(row));
        }
        return res;
    }
}