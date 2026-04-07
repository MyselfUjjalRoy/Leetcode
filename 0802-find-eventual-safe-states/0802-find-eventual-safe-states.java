class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int i = 0; i < V; i++){
            int[] edges = graph[i];
            for(int v : edges){
                adj.get(v).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);

            for(int nei : adj.get(node)){
                indegree[nei]--;

                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        Collections.sort(list);

        return list;
    }
}