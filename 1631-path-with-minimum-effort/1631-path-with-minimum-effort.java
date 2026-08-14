class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(a[0] , b[0]));
        pq.offer(new int[]{0 , 0 , 0});

        int[][] effort = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            Arrays.fill(effort[i] , Integer.MAX_VALUE);
        }
        
        effort[0][0] = 0;

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == rows - 1 && c == cols - 1) return currEffort;

            for(int d = 0; d < 4; d++){
                int nR = r + dir[2 * d];
                int nC = c + dir[2 * d + 1];

                if(nR >= 0 && nC >= 0 && nR < rows && nC < cols){
                    int diff = Math.abs(heights[r][c] - heights[nR][nC]);
                    int newEffort = Math.max(currEffort , diff);

                    if(newEffort < effort[nR][nC]){
                        effort[nR][nC] = newEffort;
                        pq.offer(new int[]{newEffort , nR , nC});
                    }
                }
            }
        }

        return -1; // unreachable
    }
}