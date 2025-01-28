class Solution {
    public int countElements(int[] nums) 
    {
        int c=0;
        Arrays.sort(nums);
        if(nums.length<=2)
        {
            return 0;
        }
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]>nums[0] && nums[i]<nums[nums.length-1])
            {
                c++;
            }
        }
        return c;
    }
} 