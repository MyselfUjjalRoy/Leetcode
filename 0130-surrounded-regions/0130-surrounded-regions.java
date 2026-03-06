class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            if(board[i][0] == 'O') dfs( n , m , board , i , 0); 
            if(board[i][m - 1] == 'O') dfs(n , m , board , i , m - 1);
        }
        for(int j = 0; j < m; j++){
            if(board[0][j] == 'O') dfs(n , m , board , 0 , j);
            if(board[n - 1][j] == 'O') dfs(n , m , board , n - 1 , j);
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void dfs(int n , int m , char[][] board , int row , int col){
        if(row < 0 || col < 0 || row >= n || col >= m || board[row][col] != 'O') return;

        board[row][col] = '#';
        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};
        for(int i = 0; i < 4; i++){
            int nRow = row + dx[i];
            int nCol = col + dy[i];

            dfs(n , m , board , nRow , nCol);
        }
    }
}