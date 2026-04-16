class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i] , k -> new ArrayList<>()).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        for(int q : queries){
            int element = nums[q];

            List<Integer> list = map.get(element);
            int size = list.size();

            int pos = Collections.binarySearch(list , q);

            if(size == 1){
                ans.add(-1);
                continue;
            }

            int minDistance = Integer.MAX_VALUE;

            int left = list.get((pos - 1 + size) % size);
            int d = Math.abs(q - left);
            int circularDist = n - d;

            minDistance = Math.min(d , circularDist);

            int right = list.get((pos + 1) % size);
            d = Math.abs(q - right);
            circularDist = n - d;

            minDistance = Math.min(minDistance , Math.min(d , circularDist));

            ans.add(minDistance);
        }

        return ans;
    }
}