class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        for(int num : nums){
            ArrayList<Integer> l = new ArrayList<>();
            while(num != 0){
                int rem = num % 10;
                l.add(rem);
                num /= 10;
            }
            Collections.reverse(l);
            list.addAll(l);
        }

        int[] ans = new int[list.size()];
        int idx = 0;

        for(int num : list){
            ans[idx++] = num;
        }

        return ans;
    }
}