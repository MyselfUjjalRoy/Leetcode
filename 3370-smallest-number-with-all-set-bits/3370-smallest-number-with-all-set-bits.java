class Solution {
    public int smallestNumber(int n) {
        int val = 1, k = 1;
        while(n > val){
            val = (int)Math.pow(2 , k) - 1;
            k++;
        }
        return val;
    }
}