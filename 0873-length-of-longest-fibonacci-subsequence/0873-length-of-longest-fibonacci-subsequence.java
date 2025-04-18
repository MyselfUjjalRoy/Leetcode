class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int n=arr.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prev=arr[j];
                int curr=arr[i]+arr[j];
                int len=2;
                while(set.contains(curr)){
                    int temp=curr;
                    curr+=prev;
                    prev=temp;
                    maxLen=Math.max(++len,maxLen);
                }
            }
        }
        return maxLen;
    }
}