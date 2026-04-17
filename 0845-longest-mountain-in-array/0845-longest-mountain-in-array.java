class Solution {
    /*
     previously solved with 2 pass , now solved in 1 pass
     and O(1) space , because in the question it was asked to do in that way
    */
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int i = 1;
        int ans = 0;

        while(i < n - 1){
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1]){
                int left = i - 1 , right = i + 1;
                while(left > 0 && arr[left - 1] < arr[left]){
                    left--;
                }

                while(right < n && arr[right] > arr[right + 1]){
                    right++;
                }

                ans = Math.max(ans , right - left + 1);
                i = right; // to skip the processed part
            }
            else{
                i++;
            }
        }

        return ans;
    }
}