class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9 + 7;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj.get(u).add(new int[]{v , wt});
            adj.get(v).add(new int[]{u , wt});
        }

        long[] dist = new long[n];
        Arrays.fill(dist , Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a , b) -> Long.compare(a[0] , b[0]));
        pq.offer(new long[]{0 , 0}); // [time , node];

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long time = curr[0];
            int node = (int)curr[1];

            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int nextTime = nei[1];

                if(time + nextTime < dist[nextNode]){
                    dist[nextNode] = time + nextTime;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{dist[nextNode] , nextNode});
                }
                else if(time + nextTime == dist[nextNode]){
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }

       return ways[n - 1];
    }
}