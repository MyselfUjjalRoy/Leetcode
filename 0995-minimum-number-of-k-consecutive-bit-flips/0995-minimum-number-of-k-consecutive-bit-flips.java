/*
solution -> CodestoryWithMik
approach 2 -> just removing the space for isFlipped by adding a marker at the original array, 2 means isFlipped = true

*/
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCountFromPastForCurr_Idx = 0;
       // boolean[] isFlipped = new boolean[n];

        int flips = 0;

        for(int i = 0; i < n; i++){
            if(i >= k && nums[i - k] == 2){
                flipCountFromPastForCurr_Idx--;
            }

            if(flipCountFromPastForCurr_Idx % 2 == nums[i]){
                if(i + k > n){
                    return -1;
                }

                flipCountFromPastForCurr_Idx++;
                nums[i] = 2;
                flips++;
            }
        }
        return flips;
    }
}