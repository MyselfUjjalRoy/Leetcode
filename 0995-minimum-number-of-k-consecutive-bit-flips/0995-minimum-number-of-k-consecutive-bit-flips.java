class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCountFromPastForCurr_Idx = 0;
        boolean[] isFlipped = new boolean[n];

        int flips = 0;

        for(int i = 0; i < n; i++){
            if(i >= k && isFlipped[i - k] == true){
                flipCountFromPastForCurr_Idx--;
            }

            if(flipCountFromPastForCurr_Idx % 2 == nums[i]){
                if(i + k > n){
                    return -1;
                }

                flipCountFromPastForCurr_Idx++;
                isFlipped[i] = true;
                flips++;
            }
        }
        return flips;
    }
}