class Solution {
    public int countHomogenous(String s) {
        int count=0;
        int MOD=(int)1e9+7;
        int ans=0;
        for(int i=0;i<s.length();i++){
            if(i==0||s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }
            ans=(ans+count)%MOD;
        }
        return ans;
    }
}