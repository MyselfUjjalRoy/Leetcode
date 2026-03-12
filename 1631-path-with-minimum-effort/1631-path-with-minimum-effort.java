class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(effort[i] , Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b)-> a[0] - b[0]);
        pq.offer(new int[]{0 , 0 , 0}); //[effort , row , col]

        int[] dx = {-1 , 0 , 1 , 0};
        int[] dy = {0 , 1 , 0 , -1};

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int currEffort = cell[0] , row = cell[1] , col = cell[2];

            if(row == rows - 1 && col == cols - 1) return currEffort;

            for(int i = 0; i < 4; i++){
                int nRow = row + dx[i];
                int nCol = col + dy[i];

                if(nRow >= 0 && nCol >= 0 && nRow < rows && nCol < cols){
                    int diff = Math.abs(heights[row][col] - heights[nRow][nCol]);
                    int newEffort = Math.max(currEffort , diff);

                    if(newEffort < effort[nRow][nCol]){
                        effort[nRow][nCol] = newEffort;
                        pq.offer(new int[]{newEffort , nRow , nCol});
                    }
                }
            }
        }
        return 0;
    }
}