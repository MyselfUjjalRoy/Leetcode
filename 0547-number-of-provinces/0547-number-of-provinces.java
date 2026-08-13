class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int provinces = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i , adj , visited);
                provinces++;
            }
        }

        return provinces;
    }

    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;

        for(int nei : adj.get(node)){
            if(!visited[nei]){
                dfs(nei , adj , visited);
            }
        }
    }
}