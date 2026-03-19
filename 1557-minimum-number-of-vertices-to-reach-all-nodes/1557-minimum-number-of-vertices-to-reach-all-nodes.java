class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> list = new ArrayList<>();

        boolean[] indegree = new boolean[n];

        for(int i = 0; i < edges.size(); i++){
            List<Integer> l = edges.get(i);
            int u = l.get(0);
            int v = l.get(1);

            indegree[v] = true;
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == false){
                list.add(i);
            }
        }
        return list;
    }
}