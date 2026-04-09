class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int u , int v){
        int pU = find(u);
        int pV = find(v);

        if(pU == pV) return;

        if(rank[pU] < rank[pV]){
            parent[pU] = pV;
        }
        else if(rank[pU] > rank[pV]){
            parent[pV] = pU;
        }
        else{
            parent[pV] = pU;
            rank[pU]++;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isConnected[i][j] == 1){
                    union(i , j);
                }
            }
        }

        int provinces = 0;

        for(int i = 0; i < n; i++){
            if(parent[i] == i) provinces++;
        }

        return provinces;
    }
}