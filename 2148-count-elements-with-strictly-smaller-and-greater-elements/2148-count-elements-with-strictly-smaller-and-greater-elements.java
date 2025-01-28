class Solution {
    public int countElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        int i=1;
        while(i<n-1){
            if(nums[i]==nums[0] || nums[i]==nums[n-1]){
                i++;
            }
            else{
                count++;
                i++;
            }
        }
        return count;
    }
}