class CustomStack {
    // LAZY UPDATE
    Deque<Integer> stack;
    int[] increment;
    int maxSize;
    public CustomStack(int maxSize) {
        stack = new ArrayDeque<>();
        increment = new int[maxSize];
        this.maxSize = maxSize;
    }
    
    public void push(int x) {
        if(stack.size() < maxSize)
            stack.addLast(x);
    }
    
    public int pop() {
        if(stack.size() == 0) return -1;
        int index = stack.size() - 1;
        int value = stack.removeLast() + increment[index];
        if(index - 1 >= 0) 
            increment[index - 1] += increment[index];
        increment[index] = 0;
        return value;
    }
    
    public void increment(int k, int val) {
        int index = Math.min(k, stack.size()) - 1;
        if(index >= 0)
            increment[index] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */