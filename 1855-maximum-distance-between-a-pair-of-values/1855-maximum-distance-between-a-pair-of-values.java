class Solution {
    /*
     previously solve with binary search , time complexity O(n log m)
     imporvement possible - O(n + m) - two pointer approach
    */
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int ans = 0;
        int j = 0;

        for(int i = 0; i < n; i++){
            while(j < m && nums2[j] >= nums1[i]){
                j++;
            }
            ans = Math.max(ans , (j - 1) - i); // -1 because here j is first invalid 
        }

        return ans;
    }
}