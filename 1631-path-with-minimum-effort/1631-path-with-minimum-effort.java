class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        pq.offer(new int[]{0 , 0 , 0}); // [effort , row , col]

        int[][] effort = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(effort[i] , Integer.MAX_VALUE);
        }
        effort[0][0] = 0;

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if(row == rows - 1 && col == cols - 1) return currEffort;

            for(int d = 0; d < 4; d++){
                int nRow = row + dir[2 * d];
                int nCol = col + dir[2 * d + 1];

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

        return 0; // will never reach here;
    }
}