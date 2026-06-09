class Solution {
    public int findLongestChain(int[][] pairs) {
      Arrays.sort(pairs,(a,b)->a[0]-b[0]);
      int n=pairs.length;
        int list[]=new int[n];
        Arrays.fill(list,1);
        int maxLength=1;
        for(int i=1;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(pairs[prev][1]<pairs[i][0]){
                    list[i]=Math.max(list[i],1+list[prev]);
                    maxLength = Math.max(maxLength , list[i]);
                }
            }
            // if(list[i]>maxLength){
            //     maxLength=list[i];
            // }
        }
        return maxLength;  
    }
}