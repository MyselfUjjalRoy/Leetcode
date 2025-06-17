class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int children = 0;
        int cookie = 0;

        while(children < g.length && cookie < s.length){
            if(g[children] <= s[cookie]){
                children++;
            }
            cookie++;
        }
        return children;
    }
}