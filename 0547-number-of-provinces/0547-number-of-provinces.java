class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];

        int components = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i , adj , visited);
                components++;
            }
        }
        return components;
    }
    public void dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;

        for(int nbr : adj.get(node)){
            if(!visited[nbr]){
                dfs(nbr , adj , visited);
            }
        }
    }
}