class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1 , Integer.MAX_VALUE);
        Arrays.fill(dist2 , Integer.MAX_VALUE);
        
        bfs(edges , node1 , dist1);
        bfs(edges , node2 , dist2);

        int minDistTillNow = Integer.MAX_VALUE;
        int minNode = -1;

        for(int i = 0; i < n; i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE){
                int maxDist = Math.max(dist1[i] , dist2[i]);
                if(maxDist < minDistTillNow){
                    minDistTillNow = maxDist;
                    minNode = i;
                }
            }
        }
        return minNode;
    }
    public void bfs(int[] edges , int node , int[] dist){
        int n = edges.length;
        boolean[] visited = new boolean[n];
        
        dist[node] = 0;
        visited[node] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            int u = queue.poll();
            int to = edges[u];
            if(to != -1 && !visited[to]){
                queue.offer(to);
                dist[to] = dist[u] + 1;
                visited[to] = true;
            }
        }
    }
}