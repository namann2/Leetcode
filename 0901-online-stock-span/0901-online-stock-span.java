class StockSpanner {

    Deque<int[]> stack; // i, a[i]
    int index;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        index = 0;
    }
    
    public int next(int price) {
        while(!stack.isEmpty() && stack.peekLast()[1] <= price)
            stack.removeLast();
        int ans = stack.isEmpty() ? index + 1 : index - stack.peekLast()[0]; 
        stack.addLast(new int[]{index++, price});
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */