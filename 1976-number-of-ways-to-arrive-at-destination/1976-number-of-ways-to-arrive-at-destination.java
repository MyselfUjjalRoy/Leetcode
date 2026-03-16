class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1] , road[2]});
            adj.get(road[1]).add(new int[]{road[0] , road[2]});
        }

        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a , b) -> Long.compare(a[0] , b[0]));
        pq.offer(new long[]{0 , 0}); // [dist , node]

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int time = (int)curr[0];
            int node = (int)curr[1];

            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int nextTime = nei[1];
                if(time + nextTime < dist[nextNode]){
                    dist[nextNode] = time + nextTime;
                    ways[nextNode] = ways[node] % MOD; 
                    pq.offer(new long[]{dist[nextNode] , nextNode});
                }
                else if(time + nextTime == dist[nextNode]){
                    ways[nextNode] = (ways[node] + ways[nextNode]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}