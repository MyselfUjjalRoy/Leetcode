class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) return 0;
        int n = routes.length;
        Map<Integer , List<Integer>> adj = new HashMap<>();

        for(int route = 0; route < n; route++){
            for(int stop : routes[route]){
                adj.computeIfAbsent(stop , k-> new ArrayList<>()).add(route);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for(int route : adj.getOrDefault(source , Collections.emptyList())){
            queue.offer(route);
            visited[route] = true;
        }

        int busCount = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size-- > 0){
                int route = queue.poll();

                for(int stop : routes[route]){
                    if(stop == target) return busCount;

                    for(int nextRoute : adj.getOrDefault(stop , Collections.emptyList())){
                        if(!visited[nextRoute]){
                            queue.offer(nextRoute);
                            visited[nextRoute] = true;
                        }
                    }
                }
            }
            busCount++;
        }
        return -1;
    }
}