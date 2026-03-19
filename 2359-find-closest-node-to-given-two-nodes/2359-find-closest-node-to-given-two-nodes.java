class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1 , Integer.MAX_VALUE);
        Arrays.fill(dist2 , Integer.MAX_VALUE);

        dist1[node1] = 0;
        dist2[node2] = 0;

        boolean[] visited1 = new boolean[n];
        boolean[] visited2 = new boolean[n];


        dfs(node1 , edges , visited1 , dist1);
        dfs(node2 , edges , visited2 , dist2);

        int minNode = -1;
        int minDistanceTillNow = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE){
                int maxDist = Math.max(dist1[i] , dist2[i]);

                if(maxDist < minDistanceTillNow){
                    minDistanceTillNow = maxDist;
                    minNode = i;
                }
            }
        }
        return minNode;
    }
    public void dfs(int node , int[] edges , boolean[] visited , int[] dist){
        visited[node] = true;
        int v = edges[node];
        

        while(v != -1 && !visited[v]){
            dist[v] = dist[node] + 1;
            dfs(v , edges , visited , dist);
        }
    }
}