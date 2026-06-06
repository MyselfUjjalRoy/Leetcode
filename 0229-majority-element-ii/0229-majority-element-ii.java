class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(cnt1 == 0 && nums[i]!= ele2){
                cnt1 = 1;
                ele1 = nums[i];
            }
            else if(cnt2 ==0 && nums[i] != ele1){
                cnt2 = 1; 
                ele2 = nums[i];
            }
            else if(ele1 == nums[i]) cnt1++;
            else if(ele2 == nums[i]) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        cnt1 = 0; cnt2 = 0;

         cnt1 = 0;
        cnt2 = 0;

        for(int num : nums){
            if(num == ele1){
                cnt1++;
            }
            else if(num == ele2){
                cnt2++;
            }
        }
        int mini = nums.length/3+1;

        if(cnt1 >= mini) {
            list.add(ele1);
        }

        if(cnt2 >= mini){
            list.add(ele2);
        }

        Collections.sort(list); 
        return list;
    }
}