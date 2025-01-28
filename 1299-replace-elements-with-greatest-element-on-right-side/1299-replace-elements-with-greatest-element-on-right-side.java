class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        int[] result=new int[n];
      
        int currentMax=-1;
        for(int i=n-1;i>=0;i--){
            result[i]=currentMax;
            currentMax=Math.max(arr[i],currentMax);
        }
        return result;
    }
}