class MovingAverage {
    int wsize, sum, csize;
    Deque<Integer> q;
    public MovingAverage(int size) {
        q = new ArrayDeque<>();
        wsize = size;
    }
    
    public double next(int val) {
        q.addLast(val);
        sum += val;
        csize++;
        while(q.size() > wsize) {
            sum -= q.removeFirst();
            csize = wsize;
        }
        return 1d * sum / csize;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */