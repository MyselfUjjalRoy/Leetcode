class Solution {
    class DSU{
        int[] parent;
        int[] size;
        DSU(int n){
            parent = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                size[i] = 0;
            }
        }
        public int findParent(int x){
            if(parent[x] != x){
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        public void union(int a , int b){
            int pA = findParent(a);
            int pB = findParent(b);

            if(pA == pB) return;

            if(size[pA] < size[pB]){
                parent[pA] = pB;
                size[pB] += size[pA];
            }
            else{
                parent[pB] = pA;
                size[pA] += size[pA];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);
        Map<String , Integer> emailToIndex = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = 1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);

                if(!emailToIndex.containsKey(email)){
                    emailToIndex.put(email , i);
                }
                else{
                    dsu.union(i , emailToIndex.get(email));
                }
            }
        }

        List<List<String>> mergedEmail = new ArrayList<>();
        for(int i = 0; i < n; i++) mergedEmail.add(new ArrayList<>());

        for(String email : emailToIndex.keySet()){
            int ultParent = dsu.findParent(emailToIndex.get(email));
            mergedEmail.get(ultParent).add(email);
        }

        List<List<String>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(mergedEmail.get(i).size() == 0) continue;

            Collections.sort(mergedEmail.get(i));
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));// adding name
            temp.addAll(mergedEmail.get(i)); // adding emails
            list.add(temp);
        }

        return list;

    }
}