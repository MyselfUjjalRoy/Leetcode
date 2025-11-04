class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
       int n = nums.length;
       int[] ans = new int[n- k + 1];
       for(int i = 0; i < n - k + 1; i++){
        int[] arr = Arrays.copyOfRange(nums , i  , i + k);
        ans[i] = getSum(arr , x);
       }
       return ans;
    }
    public int getSum(int[] arr , int x){
         Map<Integer , Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int num : map.keySet()){
            list.add(new int[]{num , map.get(num)});
        }
        Collections.sort(list , (a , b)->{
            if(b[1] == a[1]) return b[0] - a[0];
            else return b[1] - a[1];
        });
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < list.size() && i < x; i++){
            set.add(list.get(i)[0]);
        }
        int sum = 0;
        for(int num : arr){
            if(set.contains(num)){
                sum += num;
            }
        }
        return sum;
    }
}