class Solution {
    int MOD = (int)1e9 + 7;

    public long power(long base , long exponent){
        if(exponent == 0){
            return 1;
        }

        long half = power(base , exponent / 2);
        long result = (half * half) % MOD;

        if(exponent % 2 == 1){
            result = (result * base) % MOD;
        }

        return result;
    }

    public int getMaxDepth(Map<Integer , List<Integer>> adj , int node , int parent){
        int depth = 0;

        for(int nei : adj.get(node)){
            if(nei == parent) continue;

            depth = Math.max(depth , getMaxDepth(adj , nei , node) + 1);
        }

        return depth;
    }
    public int assignEdgeWeights(int[][] edges) {
        Map<Integer , List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u , k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v , k -> new ArrayList<>()).add(u);
        }

        int maxDepth = getMaxDepth(adj , 1 , -1);

        return (int)power(2 , maxDepth - 1);
    }
}