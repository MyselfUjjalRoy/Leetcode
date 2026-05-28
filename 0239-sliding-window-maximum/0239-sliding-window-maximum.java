class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && dq.getFirst() <= i - k){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && arr[dq.getLast()] <= arr[i]){
                dq.pollLast();
            }

            dq.addLast(i);

            if(i >= k -1) ans[idx++] = arr[dq.getFirst()];
        }

        return ans;
    }
}