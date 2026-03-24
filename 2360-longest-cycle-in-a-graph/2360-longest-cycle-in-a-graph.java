class Solution {
    int longest = -1;
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];

        Arrays.fill(dist , 1);

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i , edges , dist , visited , pathVisited);
            }
        }

        return longest;
    }
    
    public boolean dfs(int node , int[] edges ,int[] dist , boolean[] visited , boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;

        int nei = edges[node];

        if(nei != -1){
            if(!visited[nei]){
                dist[nei] = dist[node] + 1;
                if(dfs(nei , edges , dist , visited , pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[nei]){
                longest = Math.max(longest , dist[node] - dist[nei] + 1);
               
            }
        }
        pathVisited[node] = false;
        return false;
    }
}