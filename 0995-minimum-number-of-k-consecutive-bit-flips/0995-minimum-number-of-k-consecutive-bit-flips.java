/*
solution -> CodestoryWithMik
approach 3 -> using deque to track i-k bit flip 

*/
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int flipCountFromPastForCurr_Idx = 0;
       // boolean[] isFlipped = new boolean[n];
        Deque<Integer> flipQueue = new LinkedList<>();

        int flips = 0;

        for(int i = 0; i < n; i++){
            if(i >= k){
                flipCountFromPastForCurr_Idx -= flipQueue.pollFirst();
            }

            if(flipCountFromPastForCurr_Idx % 2 == nums[i]){//means flip occurred
                if(i + k > n){
                    return -1;
                }

                flipCountFromPastForCurr_Idx++;
                flipQueue.addLast(1);
                flips++;
            }
            else{//means no flips
                flipQueue.addLast(0);
            }
        }
        return flips;
    }
}