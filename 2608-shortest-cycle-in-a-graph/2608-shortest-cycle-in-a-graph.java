class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int[] dist = new int[n];
            Arrays.fill(dist , -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            dist[i] = 0;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int neighbour : adj.get(node)){
                    if(dist[neighbour] == -1){
                        dist[neighbour] = dist[node] + 1;
                        queue.add(neighbour);
                    }
                    else if(dist[neighbour] >= dist[node]){
                        distance = Math.min(distance , dist[neighbour] + dist[node] + 1);
                    }
                }
            }
        }
        return distance == Integer.MAX_VALUE ? -1 : distance;
    }
}