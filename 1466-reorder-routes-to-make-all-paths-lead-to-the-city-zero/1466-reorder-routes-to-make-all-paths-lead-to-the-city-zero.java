class Solution {
    int count = 0;
    public void dfs(int node , int parent , List<List<int[]>> adj){
        
        for(int[] nei : adj.get(node)){
            if(nei[0] != parent){
                count += nei[1];
                dfs(nei[0] , node , adj);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];

            adj.get(u).add(new int[]{v , 1}); // 1 means real edge
            adj.get(v).add(new int[]{u , 0}); // 0 means edge created
        }

        dfs(0 , -1 , adj);

        return count;
    }
}