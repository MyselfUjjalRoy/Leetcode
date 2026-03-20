class Solution {
    class DSU{
        int[] parent;
        int[] size;

        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node){
            if(parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }
        public void union(int u , int v){
            int pu = find(u);
            int pv = find(v);

            if(pu == pv) return;

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }
            else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
        int getSize(int node){
            return size[find(node)];
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);

        int[] dr = {-1 , 0 , 1 , 0};
        int[] dc = {0 , 1  , 0 , -1};

        // connect all existing 1's
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0) continue;

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(isValid(nr , nc , n) && grid[nr][nc] == 1){
                        int node = r * n + c;
                        int adjNode = nr * n + nc;

                        dsu.union(node , adjNode);
                    }
                }
            }
        }

        int maxIsland = 0;

        // step 2: try converting each 0 -> 1
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1) continue;

                HashSet<Integer> uniqueParents = new HashSet<>();

                for(int d = 0; d < 4; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if(isValid(nr , nc , n) && grid[nr][nc] == 1){
                        uniqueParents.add(dsu.find(nr * n + nc));
                    }
                }
                
                int newSize = 1; // including the flipped cell

                for(int parent : uniqueParents){
                    newSize += dsu.size[parent];
                }
                maxIsland = Math.max(maxIsland , newSize);
            }
        }

        // step 3 : Handle case when grid has no 0 then maxIsand will be 0
        for(int i = 0; i < n * n; i++){
            maxIsland = Math.max(maxIsland , dsu.getSize(i));
        }

        return maxIsland;
    }
    public boolean isValid(int r , int c , int n){
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}