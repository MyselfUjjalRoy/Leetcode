class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];

            adj.get(u).add(new int[]{v , wt});
        }

        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> Integer.compare(a[0] , b[0]));
        pq.offer(new int[]{0 , src , 0}); // [stops , node , cost]

        dist[src] = 0;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int stops = curr[0];
            int u = curr[1];
            int cost = curr[2];

            if(stops > k) continue;

            for(int[] nei : adj.get(u)){
                int v = nei[0];
                int wt = nei[1];

                if(cost + wt < dist[v] && stops <= k){
                    dist[v] = cost + wt;
                    pq.offer(new int[]{stops + 1 , v , dist[v]});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}