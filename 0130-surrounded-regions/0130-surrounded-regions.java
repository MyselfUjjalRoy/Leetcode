class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            if(board[i][0] == 'O') dfs(m , n , i , 0 , board);
            if(board[i][n - 1] == 'O') dfs(m , n , i , n - 1 , board);
        }

        for(int j = 0; j < n; j++){
            if(board[0][j] == 'O') dfs(m , n , 0 , j , board);
            if(board[m - 1][j] == 'O') dfs(m , n , m - 1, j , board);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

    public void dfs(int m , int n , int r , int c , char[][] board){
        if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') return;
        
        board[r][c] = '#';

        for(int d = 0; d < 4; d++){
            int nR = r + dir[2 * d];
            int nC = c + dir[2 * d + 1];

            dfs(m , n , nR , nC , board);
        }
    }
}