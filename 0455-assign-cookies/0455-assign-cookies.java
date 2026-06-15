class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int len1 = g.length;
        int len2 = s.length;

        int i = 0;
        int j = 0;

        int count = 0;

        while(i < len1 && j < len2){
            if(s[j] >= g[i]){
                i++;
                count++;
            }
            j++;
        }

        return count;
    }
}