class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            for(char ch : String.valueOf(num).toCharArray()){
                list.add(ch - '0');
            }
        }

        int[] ans = new int[list.size()];
        int idx = 0;
        
        for(int num : list){
            ans[idx++] = num;
        }

        return ans;
    }
}