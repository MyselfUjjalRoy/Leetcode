class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(0 , path , ans , graph);

        return ans;
    }
    public void dfs(int node , List<Integer> path , List<List<Integer>> ans , int[][] graph){
        path.add(node);
        
        if(node == graph.length - 1){
            ans.add(new ArrayList<>(path));
        }

        for(int next : graph[node]){
            dfs(next , path , ans , graph);
        }
        path.remove(path.size() - 1);
    }
}