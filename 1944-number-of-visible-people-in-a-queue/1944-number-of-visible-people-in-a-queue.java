class Solution {
    public int[] canSeePersonsCount(int[] arr) {
     Stack<Integer> stack = new Stack<>();
     int n = arr.length;
     int[] ans = new int[n];
     for(int i = n - 1; i >= 0; i--){
        int count = 0;
        while(!stack.isEmpty() && stack.peek() < arr[i]){
            stack.pop();
            count++;
        }
        if(!stack.isEmpty()) count += 1;
        ans[i] = count;
        stack.push(arr[i]);
     }   
     return ans;
    }
}