class MedianFinder {
    
    private PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minHeap.size() == 0 || num >= minHeap.peek())
            minHeap.add(num);
        else maxHeap.add(num);
        
        if(Math.abs(minHeap.size() - maxHeap.size()) > 1)
            rebalance();
    }
    
    public double findMedian() {
        int size_maxHeap = maxHeap.size();
        int size_minHeap = minHeap.size();
        if((size_maxHeap + size_minHeap) % 2 == 0)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        return size_maxHeap > size_minHeap ? maxHeap.peek() : minHeap.peek();
    }
    
    private void rebalance() {
        if(minHeap.size() - maxHeap.size() > 1)
            maxHeap.add(minHeap.poll());
        else minHeap.add(maxHeap.poll());
    }
}
