class Solution {// used dijkstra's algo
    static class Pair{
    int node;
    int distance;
        public Pair(int node , int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    public int minCost(int n, int[][] edges) {
        Map<Integer , List<Pair>> adj = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.computeIfAbsent(u , k->new ArrayList<>()).add(new Pair(v , wt));
            adj.computeIfAbsent(v , k->new ArrayList<>()).add(new Pair(u , 2 * wt)); // reversed edge
        }
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[0] = 0;

        //Min heap w.r.t distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a , b)-> a.distance - b.distance);
        pq.offer(new Pair(0 , 0)); // [node , distance]

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.node;
            int d = curr.distance;

            if(d > dist[node]) continue;

            if(node == n - 1) return d;

            if(adj.get(node) == null) continue;

            for(Pair nei : adj.get(node)){
                int nextNode = nei.node;
                int weight = nei.distance;
                if(d + weight < dist[nextNode]){
                    dist[nextNode] = d + weight;
                    pq.offer(new Pair(nextNode , dist[nextNode]));
                }
            }
        }
        return -1;        
    }
}