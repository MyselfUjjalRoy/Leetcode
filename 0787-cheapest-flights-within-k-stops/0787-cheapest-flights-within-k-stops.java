class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];

            adj.get(from).add(new int[]{to , cost});
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;

        queue.offer(new int[]{src , 0 , 0}); //[city , cost , stops]

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(stops > k) continue;

            for(int[] nei : adj.get(city)){
                int nextCity = nei[0];
                int price = nei[1];
                int totalPrice = cost + price;
                
                if(totalPrice < dist[nextCity]){
                    dist[nextCity] = totalPrice;
                    queue.offer(new int[]{nextCity , totalPrice , stops + 1});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}