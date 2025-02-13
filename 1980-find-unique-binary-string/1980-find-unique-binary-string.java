class Solution {
    public String findDifferentBinaryString(String[] nums) {
       String res="";
       for(int i=0;i<nums.length;i++){
        if(nums[i].charAt(i)=='0'){
            res+='1';
        }
        else{
            res+='0';
        }
       } 
       return res;
    }
}