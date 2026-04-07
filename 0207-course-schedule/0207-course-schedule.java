class Solution {
    public boolean canFinish(int n, int[][] p) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];

        for(int[] e : p){
            adj.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }

        Queue<Integer>queue = new LinkedList<>();

        for(int i = 0;i < n ; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }

        return count == n;
    }
}