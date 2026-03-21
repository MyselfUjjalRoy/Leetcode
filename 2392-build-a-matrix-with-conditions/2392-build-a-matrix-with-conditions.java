class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> rowOrder = topoSort(rowConditions , k);
        ArryList<Integer> colOrder = topoSort(colConditions , k);

        if(rowOrder.isEmpty() || colOrder.isEmpty()){
            return new int[][]{};
        }

        Map<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0; i < k; i++){
            map.put(colOrder.get(i) , i);
        }

        int[][] mat = new int[k][k];
        
        for(int i = 0; i < k; i++){
            int element = rowOrder.get(i);
            if(map.containsKey(element)){
                mat[i][map.get(element)] = element;
            }
        }
        
        return mat;
    }
    public ArrayList<Integer> topoSort(int[][] rowConditions , int n){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n + 1]; // 1 indexed

        for(int[] con : rowConditions){
            int u = con[0];
            int v = con[1];
            adj.get(u).add(v);
            indegree[v]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // to track how many nodes are accessed means pushed into the queue

        for(int i = 1; i <= n; i++){ // as nodes are 1 to k
            if(indegree[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        ArrayList<Integer> order = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            order.add(node);

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                    count++;
                }
            }
        }

        if(count != n){
            return new ArrayList<>();
        }
        
        return order;
    }
}