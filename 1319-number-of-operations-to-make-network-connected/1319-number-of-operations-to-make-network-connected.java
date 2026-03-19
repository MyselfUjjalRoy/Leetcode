class Solution {
    public int findParent(int node , int[] parent){
        if(parent[node] == node) return node;
        return parent[node] = findParent(parent[node] , parent);
    }
    public void unionBySize(int u , int v , int[] parent , int[] size){
        int pU = findParent(u , parent);
        int pV = findParent(v , parent);

        if(pU == pV) return;

        if(size[pU] < size[pV]){
            parent[pU] = pV;
        }
        else{
            parent[pV] = pU;
            size[pU] = size[pU] + size[pV];
        }
    }
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 0;
        }

        int extraEdges = 0;

        for(int[] conn : connections){
            int u = conn[0];
            int v = conn[1];

            if(findParent(u , parent) == findParent(v , parent)) extraEdges++;
            else{
                unionBySize(u , v , parent , size);
            }
        }

        int component = 0;

        for(int i = 0; i < n; i++){
            if(parent[i] == i){
                component++;
            }
        }

        int required = component - 1;

        return extraEdges >= required ? required : -1;
    }
}