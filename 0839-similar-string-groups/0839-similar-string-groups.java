class Solution {

    public boolean isSimilar(String s1 , String s2){
        int n = s1.length();
        int diff = 0;

        for(int i = 0; i < n; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
        }

        return diff == 0 || diff == 2;
    }

    public void dfs(int node , Map<Integer , ArrayList<Integer>> adj , boolean[] visited){
        visited[node] = true;

        for(int nei : adj.getOrDefault(node , new ArrayList<>())){
            if(!visited[nei]){
                dfs(nei , adj , visited);
            }
        }
    }
    public int numSimilarGroups(String[] s) {
        int n = s.length;

        Map<Integer , ArrayList<Integer>> adj = new HashMap<>();

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(isSimilar(s[i] , s[j])){
                    adj.computeIfAbsent(i , k -> new ArrayList<>()).add(j);
                    adj.computeIfAbsent(j , k -> new ArrayList<>()).add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i , adj , visited);
                count++;
            }
        }

        return count;
    }
}