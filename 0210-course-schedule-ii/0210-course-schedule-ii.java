class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int v : adj.get(i)){
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] topoSort = new int[numCourses];
        int idx = 0;

        while(!queue.isEmpty()){
            int u = queue.poll();
            topoSort[idx++] = u;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    queue.offer(v);
                }
            }
        }

        if(idx == numCourses) return topoSort;
        else return new int[]{};
    }
}