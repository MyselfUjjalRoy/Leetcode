class Solution {
    int n;
    public int[] getCoordinate(int cell){
        int row = (n - 1) - (cell - 1) / n;
        int col = (cell - 1) % n;

        if((n % 2 == 0 && row % 2 == 0) || (n % 2 == 1 && row % 2 == 1)){
            col = (n - 1) - col;
        }

        return new int[]{row , col};
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);
        visited[n - 1][0] = true;

        int steps = 0;

        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-- > 0){
                int curr = queue.poll();

                if(curr == n * n) return steps;


                for(int d = 1; d <= 6; d++){
                    int next = curr + d;

                    if(next > n * n) break;

                    int[] coordinate = getCoordinate(next);

                    int r = coordinate[0];
                    int c = coordinate[1];

                    if(visited[r][c]) continue;

                    visited[r][c] = true;

                    if(board[r][c] == -1){
                        queue.offer(next);
                    }
                    else{
                        queue.offer(board[r][c]);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}