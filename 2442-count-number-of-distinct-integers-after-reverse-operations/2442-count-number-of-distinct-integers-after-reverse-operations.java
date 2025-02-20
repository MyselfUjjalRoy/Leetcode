class Solution {
    public int reverse(int num){
        int sum=0;
        while(num!=0){
            sum=sum*10+(num%10);
            num/=10;
        }
        return sum;
    }
    public int countDistinctIntegers(int[] nums) {
       Set<Integer> set = new HashSet<>();
       for(int num:nums){
        set.add(num);
        set.add(reverse(num));
       }
       return set.size();
    }
}