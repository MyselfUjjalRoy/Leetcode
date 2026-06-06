class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            adj.get(u).add(new int[]{v , wt});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a , b) -> a[0] - b[0]);
        pq.offer(new int[]{0 , k}); // [time , node]

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            for(int[] nei : adj.get(node)){
                int v = nei[0];
                int wt = nei[1];

                if(time + wt < dist[v]){
                    dist[v] = time + wt;
                    pq.offer(new int[]{dist[v] , v});
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans , dist[i]);
        }

        return ans;
    }
}