class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean hasEven = false;
        boolean hasOdd = false;
        int minOdd = Integer.MAX_VALUE;
        for(int num : nums1){
            if(num % 2 == 0) hasEven = true;
            if(num % 2 != 0) hasOdd = true;
            minOdd = Math.min(minOdd , num);
        }

        if(!hasEven || !hasOdd) return true;

        for(int num : nums1){
            if(num % 2 == 0 && num <= minOdd){
                return false;
            }
        }
        return true;
    }
}