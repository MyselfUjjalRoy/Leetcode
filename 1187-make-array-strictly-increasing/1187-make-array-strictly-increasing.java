class Solution {
    Map<String , Integer> map;
    public int solve(int idx , int[] arr1 , int[] arr2 , int prev){
        if(idx == arr1.length) return 0;

        String key = idx + "_" + prev;

        if(map.containsKey(key)){
            return map.get(key);
        }

        int option1 = (int)1e9 + 1;
        if(arr1[idx] > prev){
            option1 = solve(idx + 1 , arr1 , arr2 , arr1[idx]);
        }

        int option2 = (int)1e9 + 1;
        int pos = upperBound(arr2 , prev);
        if(pos < arr2.length){
            option2 = 1 + solve(idx + 1 , arr1 , arr2 , arr2[pos]);
        }

        int ans = Math.min(option1 , option2);

        map.put(key , ans);

        return ans;
    }

    public int upperBound(int[] arr , int element){
        int left = 0;
        int right = arr.length - 1;
        int ans = arr.length;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] > element){
                ans = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return ans;
    }
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        
        map = new HashMap<>();

        int ans = solve(0 , arr1 , arr2 , Integer.MIN_VALUE);

        return ans == (int)1e9 + 1 ? -1 : ans;
    }
}