class Solution {
    public long removeZeros(long n) {
        String val = Long.toString(n);
        StringBuilder sb = new StringBuilder();
        for(char ch : val.toCharArray()){
            if(ch == '0'){
                continue;
            }
            else{
                sb.append(ch);
            }
        }
        return Long.parseLong(sb.toString());
    }
}