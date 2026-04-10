/*    abs(i - j) + abs(j - k) + abs(k - i)
    = (j - i) + (k - j) + (k - i) = 2 * ( k - i)
*/
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        Map<Integer , List<Integer>> map = new HashMap<>();

        int ans = n;
        for(int k = 0; k < n; k++){
            map.computeIfAbsent(nums[k] , j-> new ArrayList<>()).add(k);

            if(map.get(nums[k]).size() >= 3){
                int size = map.get(nums[k]).size();
                int i = map.get(nums[k]).get(size - 3);

                ans = Math.min(ans , k - i);

            }
        }

        return ans >= n ? -1 : 2 * ans;
    }
}