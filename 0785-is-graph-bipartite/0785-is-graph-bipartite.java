class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color , -1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(dfs(i , 0 , color , graph) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(int node , int clr , int[] color , int[][] graph){
        color[node] = clr;
        for(int nei : graph[node]){
            if(color[nei] == -1){
                if(dfs(nei , 1 - clr , color , graph) == false){
                    return false;
                }
            }
            else if(color[nei] == clr){
                return false;
            }
        }
        return true;
    }
}