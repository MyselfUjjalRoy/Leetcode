class Solution {
    int minDist = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1] , road[2]});
            adj.get(road[1]).add(new int[]{road[0] , road[2]});
        }

        boolean[] visited = new boolean[n + 1];

        dfs(1 , adj , visited);

        return minDist;
    }
    public void dfs(int node , ArrayList<ArrayList<int[]>> adj , boolean[] visited){
        visited[node] = true;

        for(int[] nei : adj.get(node)){
            int adjNode = nei[0];
            int wt = nei[1];

            minDist = Math.min(minDist , wt);

            if(!visited[adjNode]){
                dfs(adjNode , adj , visited);
            }
        }
    }
}