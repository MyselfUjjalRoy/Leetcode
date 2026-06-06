class Solution {
    class DSU{
        int[] parent;
        int[] rank;
        DSU(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int node){
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        boolean union(int u , int v){
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return false;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }
            else if(rank[pv] < rank[pu]){
                parent[pv] = pu;
            }
            else{
                parent[pv] = pu;
                rank[pu]++;
            }

            return true;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU dsu = new DSU(n);

        int extraEdge = 0;
        int component = n;

        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];

            if(dsu.union(u , v) == false){
                extraEdge++;
            }
            else{
                component--;
            }
        }

        int required = component - 1;

        return extraEdge >= required ? required : -1;
    }
}