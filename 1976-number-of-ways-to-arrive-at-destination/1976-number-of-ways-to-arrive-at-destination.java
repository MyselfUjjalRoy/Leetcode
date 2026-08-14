class Solution {
    int MOD = (int)(1e9 + 7);
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            adj.get(u).add(new int[]{v , time});
            adj.get(v).add(new int[]{u , time});
        }

        long[] dist = new long[n];
        Arrays.fill(dist , Long.MAX_VALUE);
        dist[0] = 0;

        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a , b) -> Long.compare(a[0] , b[0]));
        pq.offer(new long[]{0 , 0}); // [time , node]

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long time = curr[0];
            int u = (int)curr[1];

            for(int[] nei : adj.get(u)){
                int v = nei[0];
                int wt = nei[1];

                if(time + wt < dist[v]){
                    dist[v] = time + wt;
                    ways[v] = ways[u];
                    pq.offer(new long[]{dist[v] , v});
                }
                else if(time + wt == dist[v]){
                    ways[v] = (ways[u] + ways[v]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}