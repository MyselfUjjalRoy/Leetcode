class StockSpanner {
    Stack<int[]> stack;
    int idx;
    public StockSpanner() {
        stack = new Stack<>();
        idx = -1;
    }
    
    public int next(int price) {
        idx++;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }

        int span = idx - ((stack.isEmpty()) ? -1 : stack.peek()[1]);

        stack.push(new int[]{price , idx});

        return span; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */