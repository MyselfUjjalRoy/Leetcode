class Solution {
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                size[i] = 1;
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

        int[] dir = {-1 , 0 , 1 , 0 , 0 , -1 , 0 , 1};

        // first -> connect all existing ones
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 0) continue;

                for(int d = 0; d < 4; d++){
                    int nR = r + dir[2 * d];
                    int nC = c + dir[2 * d + 1];

                    if(isValid(nR , nC , n) && grid[nR][nC] == 1){
                        int node = r * n + c;
                        int adjNode = nR * n + nC;

                        dsu.union(node , adjNode);
                    }
                }
            }
        }

        int maxIsland = 0;

        // step 2 : try converting each 0 -> 1
       
        for(int r = 0; r < n; r++){
            for(int c = 0; c < n; c++){
                if(grid[r][c] == 1) continue;

                HashSet<Integer> uniqueParents = new HashSet<>();

                for(int d = 0; d < 4; d++){
                    int nR = r + dir[2 * d];
                    int nC = c + dir[2 * d + 1];

                    if(isValid(nR , nC , n) &&  grid[nR][nC] == 1){
                        uniqueParents.add(dsu.find(nR * n + nC));
                    }
                }   
                
                int newSize = 1; // Including the flipped cell

                for(int parent : uniqueParents){
                    newSize += dsu.size[parent];
                }

                maxIsland = Math.max(maxIsland , newSize);
            }
        }

        // step 3 : Handle case when grid has no 0 then maxisland will be 0
        // so to avoid that , we need to take the max existing island without flipping

        for(int i = 0; i < n; i++){
            maxIsland = Math.max(maxIsland , dsu.getSize(i));
        }

        return maxIsland;
    }

    public boolean isValid(int r , int c , int n){
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}