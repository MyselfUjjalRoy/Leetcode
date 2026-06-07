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

        public int find(int node){
            if(parent[node] == node) return node;
            else return parent[node] = find(parent[node]);
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
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String , Integer> emailToIndex = new HashMap<>();
        
        for(int accIdx = 0; accIdx < n; accIdx++){
            int size = accounts.get(accIdx).size();
            for(int i = 1; i < size; i++){
                String email = accounts.get(accIdx).get(i);
                if(!emailToIndex.containsKey(email)){
                    emailToIndex.put(email , accIdx);
                }
                else{
                    dsu.union(accIdx , emailToIndex.get(email));
                }
            }
        }

        List<List<String>> mergedMail = new ArrayList<>();
        for(int i = 0; i < n; i++){
            mergedMail.add(new ArrayList<>());
        }

        for(String mail : emailToIndex.keySet()){
            int ultParent = dsu.find(emailToIndex.get(mail));

            mergedMail.get(ultParent).add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<String> acc = mergedMail.get(i);

            if(acc.size() == 0) continue;

            List<String> temp = new ArrayList<>();

            temp.add(accounts.get(i).get(0));// for name
            Collections.sort(acc);
            temp.addAll(acc);

            ans.add(temp);
        }

        return ans;
    }
}