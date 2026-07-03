class Solution {
    public boolean check(int minWt , int n , ArrayList<ArrayList<int[]>> adj , long k){
        long[] dist = new long[n];
        Arrays.fill(dist , Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a , b)-> Long.compare(a[0] , b[0]));

        pq.offer(new long[]{0 , 0});
        dist[0] = 0;

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long cost = curr[0];
            int u = (int)curr[1];

            if(cost > dist[u]) continue;
            if(cost  > k) return false;
            if(u == n - 1) return true;

            for(int[] edge : adj.get(u)){
                int v = edge[0];
                int wt = edge[1];

                if(wt < minWt) continue;

                long newCost = cost + wt;
                if(newCost < dist[v]){
                    dist[v] = newCost;
                    pq.offer(new long[]{newCost , v});
                }
            }
        }

        return false;
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if(!online[u] || !online[v]) continue;

            adj.get(u).add(new int[]{v , wt});

            low = Math.min(low , wt);
            high = Math.max(high , wt);
        }

        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(check(mid , n , adj , k)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }
}