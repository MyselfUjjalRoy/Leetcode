class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        int find(int node){
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        void union(int u , int v){
            int pu = find(u);
            int pv = find(v);

            if(pu != pv){
                parent[pu] = pv;
            }
        }
    }
    public int removeStones(int[][] stones) {
        int totalStones = stones.length;

        int maxRow = 0 , maxCol = 0;
        for(int[] stone : stones){
            maxRow = Math.max(maxRow , stone[0]);
            maxCol = Math.max(maxCol , stone[1]);
        }

        int offSet = maxRow + 1; // that will help to convert cols to node

        DSU dsu = new DSU(maxCol + (maxRow + 1) + 1);

        // to track which nodes are used and to count components
        HashSet<Integer> usedNodes = new HashSet<>();

        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1] + offSet;

            dsu.union(row , col);

            usedNodes.add(row);
            usedNodes.add(col);
        }

        int components = 0;
        for(int node : usedNodes){
            if(dsu.find(node) == node){
                components++;
            }
        }

        return totalStones - components;
    }
}