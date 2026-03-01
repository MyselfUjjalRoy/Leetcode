class Solution {
    public int minPartitions(String n) {
        int ans = -1;
        for(char ch : n.toCharArray()){
            if(ch - '0' > ans){
                ans = ch - '0';
            }
        }
        return ans;
    }
}