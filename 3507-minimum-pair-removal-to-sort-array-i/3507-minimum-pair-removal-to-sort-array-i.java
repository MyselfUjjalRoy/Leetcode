class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            list.add(num);
        }

        int operations = 0;
        while(!isSorted(list)){
            int index = getMinSumIndex(list);
            int mergedValue = list.get(index) + list.get(index + 1);
            list.set(index , mergedValue);
            list.remove(index + 1);
            operations++;
        }
        return operations;
    }
    public boolean isSorted(ArrayList<Integer> list){
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
    public int getMinSumIndex(ArrayList<Integer> list){
        int minSum = Integer.MAX_VALUE;
        int index = -1;
       // int sum = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++){
            int sum = list.get(i) + list.get(i + 1);
            if(sum < minSum){
                minSum = sum;
                index = i;
            }
        }
        return index;
    }
}