class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int[] inorder = new int[V];
        for(int u = 0; u < V; u++){
            for(int v : graph[u]){
                adj.get(v).add(u);
                inorder[u]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(inorder[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> safeStates = new ArrayList<>();
        while(!queue.isEmpty()){
            int u = queue.poll();
            safeStates.add(u);
            for(int v : adj.get(u)){
                inorder[v]--;
                if(inorder[v] == 0){
                    queue.offer(v);
                }
            }
        }

        Collections.sort(safeStates);
        return safeStates;
        
        
    }
}