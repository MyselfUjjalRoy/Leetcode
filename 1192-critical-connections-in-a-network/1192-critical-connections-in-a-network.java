class Solution {
    int time = 1;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> conn : connections){
            int u = conn.get(0);
            int v = conn.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] discTime = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<>();

        dfs(0 , -1 , discTime , low , adj , visited , bridges);

        return bridges;
    }

    public void dfs(int node , int parent , int[] discTime , int[] low , ArrayList<ArrayList<Integer>> adj , boolean[] visited , List<List<Integer>> bridges){
        visited[node] = true;
        discTime[node] = low[node] = time;
        time++;

        for(int nei : adj.get(node)){
            if(nei == parent) continue;

            if(!visited[nei]){
                dfs(nei , node , discTime , low , adj , visited , bridges);

                low[node] = Math.min(low[node] , low[nei]);

                if(low[nei] > discTime[node]){
                    bridges.add(Arrays.asList(node ,nei));
                }
            }
            else{
                low[node] = Math.min(low[node] , discTime[nei]);
            }
        }
    }
}