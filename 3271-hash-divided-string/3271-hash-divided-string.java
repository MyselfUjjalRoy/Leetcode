class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i+=k){
            int res=0;
            for(int j=i;j<i+k;j++){
                res+=(s.charAt(j)-'a');
            }
            res=res%26;
            char ch=(char)(res+'a');
            sb.append(String.valueOf(ch));
        }
        return sb.toString();
    }
}