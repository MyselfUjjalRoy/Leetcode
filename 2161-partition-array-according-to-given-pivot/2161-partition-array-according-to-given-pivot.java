class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int lesser = 0;
        int equal = 0;
        int greater = 0;

        for(int num : nums){
            if(num < pivot){
                lesser++;
            }
            else if(num == pivot){
                equal++;
            }
            else{
                greater++;
            }
        }

        int i = 0;
        int j = lesser;
        int k = lesser + equal;

        int[] ans = new int[n];

        for(int num : nums){
            // int num = nums[i];
            if(num < pivot){
                ans[i] = num;
                i++;
            }
            else if(num == pivot){
                ans[j] = num;
                j++; 
            }
            else{
                ans[k] = num;
                k++;
            }
        }

        return ans;
    }
}