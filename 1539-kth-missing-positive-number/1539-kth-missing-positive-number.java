class Solution {
    public int findKthPositive(int[] arr, int k) {
        for(int i = 0; i < arr.length; i++){
            if(arr[i] <= k){ // all the elements lesser than k , will take the place
                k++;
            }
            else break;
        }

        return k;
    }
}