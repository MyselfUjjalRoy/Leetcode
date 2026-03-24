class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length();
        Map<Character , List<Character>> adj = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            adj.computeIfAbsent(ch1 , k -> new ArrayList<>()).add(ch2);
            adj.computeIfAbsent(ch2 , k -> new ArrayList<>()).add(ch1);
        }

        char[] smallestChar = new char[26];
        for(char ch = 'a'; ch <= 'z'; ch++){
            boolean[] visited = new boolean[26];
            smallestChar[ch - 'a'] = dfs(ch , visited , adj);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            ans.append(smallestChar[baseStr.charAt(i) - 'a']);
        }

        return ans.toString();
    }

    public char  dfs(char curr , boolean[] visited , Map<Character , List<Character>> adj){
        visited[curr - 'a'] = true;
        char minChar = curr;
        for(char ch : adj.getOrDefault(curr , Collections.emptyList())){
            if(!visited[ch - 'a']){
                char min = dfs(ch , visited , adj);
                minChar = (char)Math.min(minChar , min);
            }
        }

        return minChar;
    }
}