class Solution {
    public int mirrorDistance(int n) {
        String num = String.valueOf(n);
        StringBuilder sb = new StringBuilder(num);
        String rev = sb.reverse().toString();
        int val = Integer.parseInt(rev);
        return Math.abs(val - n);
    }
}