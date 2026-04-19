class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int ans = 0;
        
        for(int i = 0; i < n; i++){
            int ele = nums1[i];
            int pos = binarySearch(ele , nums2);

            ans = Math.max(ans , pos - i);
        }

        return ans;
    }

    public int binarySearch(int val , int[] nums){
        int l = 0 , r = nums.length - 1;
        int ans = 0;
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(nums[mid] >= val){
                ans = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }

        return ans;
    }
}