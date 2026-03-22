class Solution {
    int N;
    int[] result;
    int[] count;
    int resultBaseNode;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N = n;
        count = new int[n];
        result = new int[n];

        Map<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // step 1 :- compute base result and subtree size

        dfsBase(adj , 0 , -1 , 0); // {adj , node , parent , depth}

        // step 2: reroot to comput all results
        result[0] = resultBaseNode;
        dfs(adj , 0 , -1);

        return result;
    }
    
    // first dfs : calculate subtree sizes and base result(node 0)
    public int dfsBase(Map<Integer , List<Integer>> adj , int curr , int parent , int depth){
        int totalNodes = 1;
        resultBaseNode += depth;

        for(int child : adj.get(curr)){
            if(child == parent) continue;
            totalNodes += dfsBase(adj , child , curr, depth + 1);
        }
        
        count[curr] = totalNodes;

        return totalNodes;
    }

    // second dfs :- rerooting to compute results for all nodes
    public void dfs(Map<Integer , List<Integer>> adj , int curr , int parent){
        for(int child : adj.get(curr)){
            if(child == parent) continue;

            result[child] = result[curr] - count[child] + (N - count[child]);

            dfs(adj , child , curr);
        }
    }
}