class Solution {
    int[] parent;
    int[] rank;
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int u , int v){
        int pU = find(u);
        int pV = find(v);

        if(pU == pV) return;

        if(rank[pU] > rank[pV]){
            parent[pV] = pU;
        }
        else if(rank[pV] > rank[pU]){
            parent[pU] = pV;
        }
        else{
            parent[pU] = pV;
            rank[pV]++;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
        }

        // add index to queries
        int q = queries.length;

        int[][] newQueries = new int[q][4];
        for(int i = 0; i < q; i++){
            newQueries[i][0] = queries[i][0];
            newQueries[i][1] = queries[i][1];
            newQueries[i][2] = queries[i][2];
            newQueries[i][3] = i;
        }

        // Sort edgesList according to edge weights
        Arrays.sort(edgeList , (a , b) -> a[2] - b[2]);

        // Sort newQueries according to limit
        Arrays.sort(newQueries , (a , b) -> a[2] - b[2]);

        boolean[] ans = new boolean[q];

        int j = 0;

        for(int[] query : newQueries){
            int u = query[0];
            int v = query[1];
            int limit = query[2];
            int idx = query[3];

            while(j < edgeList.length && edgeList[j][2] < limit){
                union(edgeList[j][0] , edgeList[j][1]);
                j++;
            }

            ans[idx] = (find(u) == find(v));
        }

        return ans;
    }
}