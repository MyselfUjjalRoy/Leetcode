class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for(int i = 1; i < n; i++){
            StringBuilder copy = new StringBuilder(sb);
            for(int j = 0; j < copy.length(); j++){
                copy.setCharAt(j , copy.charAt(j) == '0' ? '1' : '0');
            }
            sb.append("1").append(copy.reverse());
        }   
        System.out.print(sb.toString());
        return sb.charAt(k - 1);
    }
}