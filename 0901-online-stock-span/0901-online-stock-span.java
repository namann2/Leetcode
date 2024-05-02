class StockSpanner {

    Deque<int[]> stack; // a[i], spanTillCurrent
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peekLast()[0] <= price)
            span += stack.removeLast()[1];
        stack.addLast(new int[]{price, span});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */