class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n];

        for(int[] p : pre){
            adj.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            count++;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }

        return count == n;
    }
}