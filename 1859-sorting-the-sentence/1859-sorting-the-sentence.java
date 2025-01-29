class Solution {
    public String sortSentence(String s) {
        String[] str=s.split(" ");
  
        String[] ans=new String[str.length];
        for(String word:str){
            int n=word.length();
            int pos=word.charAt(n-1)-48;
            ans[pos-1]=word.substring(0,n-1);
        }
        StringBuilder sb=new StringBuilder();
        for(String res:ans){
            sb.append(res);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}