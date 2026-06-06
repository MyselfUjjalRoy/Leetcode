class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v , wt});
            adj.get(v).add(new int[]{u , wt});
        }

        int cityNo = 0;
        int minReachable = n;

        for(int i = 0; i < n; i++){
            int reachable = dijkstra(i , n , adj , distanceThreshold);

            if(reachable <= minReachable){
                minReachable = reachable;
                cityNo = i;
            }
        }

        return cityNo;
    }

    public int dijkstra(int src , int n , ArrayList<ArrayList<int[]>> adj , int distanceThreshold){
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        pq.offer(new int[]{0 , src}); // [distance , node];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int node = curr[1];

            for(int[] nei : adj.get(node)){
                int nextNode = nei[0];
                int nextCost = nei[1];

                if(cost + nextCost < dist[nextNode]){
                    dist[nextNode] = cost + nextCost;
                    pq.offer(new int[]{dist[nextNode] , nextNode});
                }
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++){
            if(dist[i] <= distanceThreshold){
                count++;
            }
        }

        return count;
    }
}

