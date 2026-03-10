class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < V; i++){
            int[] edges = graph[i];
            for(int v : edges){
                adj.get(i).add(v);
            }
        }

        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        boolean[] safe = new boolean[V];

        for(int i = 0; i < V; i++){
            dfs(i , adj , visited , pathVisited , safe);
        }
        ArrayList<Integer> nodes = new ArrayList<>();
        for(int i = 0; i < V; i++){
            if(safe[i]){
                nodes.add(i);
            }
        }

        Collections.sort(nodes);

        return nodes;
    }

    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , boolean[] pathVisited , boolean[] safe){
        visited[node] = true;
        pathVisited[node] = true;

        for(int nei : adj.get(node)){
            if(!visited[nei]){
                if(dfs(nei , adj, visited , pathVisited , safe)){
                    safe[nei] = false;
                    return true;
                }
            }
            else if(pathVisited[nei]){
                safe[nei] = false;
                return true;
            }
        }

        safe[node] = true;
        pathVisited[node] = false;

        return false;
    }
}