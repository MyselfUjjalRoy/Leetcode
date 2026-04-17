class Solution {
    public int reverse(int num){
        int rev = 0;
        while(num != 0){
            int d = num % 10;
            rev = rev * 10 + d;
            num /= 10;
        }

        return rev;
    }
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;

        Map<Integer , Integer> map = new HashMap<>(); // number , index

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int rev = reverse(nums[i]);
            System.out.println(rev);
            if(map.containsKey(nums[i])){
                ans = Math.min(ans , i - map.get(nums[i]));
            }
            map.put(rev , i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}