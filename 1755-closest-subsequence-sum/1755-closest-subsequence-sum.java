/*
generate all possible subset sums = 2^(n/2) + 2^(n/2)
sort the second array(righSums) => 2^(n/2)log 2^(n/2) = n/2*2^(n/2)
binary search on 2nd array = log 2^(n/2) = (n / 2)
no. of times binary search is triggered = size of 1st array
                                        = 2 ^(n/2)
so total search time = n/2 * 2^(n/2)

total time = generate + sort + search
           = 2^(n/2) + 2^(n/2) + n/ 2 * 2^(n/2) + n / 2 * 2^(n/2) 
           = O(n * 2^(n/2))
*/
class Solution {
    // here we have used meet in the middle algo + lowerbound 
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;

        int[] left = Arrays.copyOfRange(nums , 0 , n/2);
        int[] right = Arrays.copyOfRange(nums , n / 2 , n);

        List<Integer> leftSums = getSums(left);
        List<Integer> rightSums = getSums(right);

        Collections.sort(rightSums);

        int ans = Integer.MAX_VALUE;

        for(int sum1 : leftSums){
            int target = goal - sum1;
            int idx = lowerBound(rightSums , target);

            if(idx < rightSums.size()){
                ans = Math.min(ans , Math.abs(sum1 + rightSums.get(idx) - goal));
            }

            if(idx > 0){
                ans = Math.min(ans , Math.abs(sum1 + rightSums.get(idx - 1) - goal));
            }
        }
        return ans;
    }

    private List<Integer> getSums(int[] arr){ // helps us to get all possible subset sums
        List<Integer> sums = new ArrayList<>();
        int n = arr.length;
        
        for(int mask = 0; mask < (1 << n); mask++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                if((mask & (1 << i)) != 0){
                    sum += arr[i];
                }
            }
            sums.add(sum);
        }
        return sums;
    }
    private int lowerBound(List<Integer> list , int target){// it helps to find element >= target (return the index means where to insert in a sorted order)
        int low = 0 , high = list.size() - 1;

        int ans = list.size();

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(list.get(mid) >= target){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }
}