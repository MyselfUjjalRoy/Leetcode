class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for(int i = 0; i < n; i++){
            if(group[i] == -1){
                group[i] = m++;
            }
        }

        ArrayList<ArrayList<Integer>> itemGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];
        
        for(int i = 0; i < n; i++){
            itemGraph.add(new ArrayList<>());
        }

        ArrayList<ArrayList<Integer>> groupGraph = new ArrayList<>();
        int[] groupIndegree = new int[m];

        for(int i = 0; i < m; i++){
            groupGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            for(int prev : beforeItems.get(i)){
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                if(group[i] != group[prev]){
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        ArrayList<Integer> itemOrder = topoSort(itemGraph , itemIndegree);
        ArrayList<Integer> groupOrder = topoSort(groupGraph , groupIndegree);

        Map<Integer , ArrayList<Integer>> groupToItems = new HashMap<>();

        for(int item : itemOrder){
            int g = group[item];
            groupToItems.computeIfAbsent(g , k -> new ArrayList<>()).add(item);
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for(int g : groupOrder){
            ArrayList<Integer> items = groupToItems.get(g);
            if(items != null){
                answerList.addAll(items);
            }
        }

        int[] ans = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            ans[i] = answerList.get(i);
        }

        return ans;        
    }

    public ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj , int[] indegree){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            list.add(node);
            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    queue.offer(nei);
                }
            }
        }
        return list.size() == adj.size() ? list : new ArrayList<>();
    }
}