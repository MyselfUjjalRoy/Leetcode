class Solution {
    public boolean validDigit(int n, int x) {
        String s = String.valueOf(n);
        char ch = (char)(x + '0');

        return s.charAt(0) != ch  && s.contains(String.valueOf(ch));
    }
}