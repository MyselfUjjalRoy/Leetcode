class Solution {
    public int[] closestDivisors(int num) {
     int[] res=new int[2];
     for(int i=(int)Math.sqrt(num+2);i>=0;i--){
        if((num+1)%i==0){
            res[0]=i;
            res[1]=(num+1)/i;
            break;
        }
        else if((num+2)%i==0){
            res[0]=i;
            res[1]=(num+2)/i;
            break;
        }
     }  
     return res; 
    }
}