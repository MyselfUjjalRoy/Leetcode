class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int n = s1.length();
        for(int i = 0; i < n - 2; i++){
            if(s1.charAt(i) != s2.charAt(i)){
                char[] s = s1.toCharArray();
                char ch = s[i];
                s[i] = s[i + 2];
                s[i + 2] = ch;

                s1 = new String(s);                 
            }
        }
        return s1.equals(s2);
    }
}