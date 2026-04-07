class Solution {
    public int[] findOrder(int V, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        for(int[] p : pre){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0;i < V; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int[] ans = new int[V];
        int idx = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[idx++] = node;

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
            
        }

        return idx == V ? ans : new int[]{};

    }
}