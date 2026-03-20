class Solution {
    class DSU{
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        int find(int x){
            if(parent[x] != x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        void union(int x , int y){
            int px = find(x);
            int py = find(y);
            if(px != py){
                parent[px] = py;
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

        int offSet = maxRow + 1; // it will help to convert columns to node

        DSU dsu = new DSU(maxRow + maxCol + 2);

        // to track which nodes are actually used
        HashSet<Integer> usedNodes = new HashSet<>();

        // union row and cols

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