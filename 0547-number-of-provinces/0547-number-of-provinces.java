class Solution {
    public int findParent(int[] parent , int node){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent , parent[node]);
    }
    public void unionByRank(int u , int v , int[] parent , int[] rank){
        int pU = findParent(parent , u);
        int pV = findParent(parent , v);

        if(pU == pV) return;

        if(rank[pU] < rank[pV]){
            parent[pU] = pV;
        }
        else if(rank[pV] < rank[pU]){
            parent[pV] = pU;
        }
        else{
            parent[pV] = pU;
            rank[pU]++;
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];
        int[] rank = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){ // starting from i + 1 to avoid repetitive work
                if(isConnected[i][j] == 1){
                    unionByRank(i , j , parent , rank);
                }
            }
        }
        
        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                provinces++;
            }
        }
        return provinces;
    }
}