class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[]{v , wt});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[1] - b[1]); //[node , time]
        pq.offer(new int[]{k , 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];
            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int wt = nei[1];
                if(time + wt < dist[nextNode]){
                    dist[nextNode] = time + wt;
                    pq.offer(new int[]{nextNode , time + 1});
                }
            }
        }

        int minTime = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            minTime = Math.max(minTime , dist[i]);
        }
        return minTime;
    }
}