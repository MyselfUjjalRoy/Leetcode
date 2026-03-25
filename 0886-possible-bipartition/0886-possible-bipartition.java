class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] dislike : dislikes){
            int u = dislike[0];
            int v = dislike[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color , -1);

        for(int i = 0; i <= n; i++){
            if(color[i] == -1){
                if(!isBipartite(i , adj , color)){
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean isBipartite(int node , ArrayList<ArrayList<Integer>> adj , int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[node] = 1;

        queue.offer(node);

        while(!queue.isEmpty()){
            int u = queue.poll();

            for(int v : adj.get(u)){
                if(color[u] == color[v]) return false;

                if(color[v] == -1){
                    color[v] = 1 - color[u];
                    queue.offer(v);
                }
            }
        }
        
        return true;
    }
}