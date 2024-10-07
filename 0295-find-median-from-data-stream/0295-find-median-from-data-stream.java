/*
Complexity Analysis

Time complexity: 
O(5⋅logn)+O(1)≈O(logn).
    At worst, there are three heap insertions and two heap deletions from the top. Each of these takes about O(logn) time. 
    Finding the median takes constant O(1), since the tops of heaps are directly accessible.

Space complexity: 
O(n) linear space to hold input in containers.

*/

class MedianFinder {
    
    PriorityQueue<Integer> maxHeap, minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(minHeap.size() == 0 || num >= minHeap.peek())
            minHeap.offer(num);
        else maxHeap.offer(num);
        
        if(Math.abs(minHeap.size() - maxHeap.size()) > 1)
            rebalance();
    }
    
    public double findMedian() {
        int maxs = maxHeap.size();
        int mins = minHeap.size();
        int size = maxs + mins;
        if(size % 2 != 0)
            return maxs > mins ? maxHeap.peek() : minHeap.peek();
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
    
    private void rebalance() {
        if(minHeap.size() > maxHeap.size() + 1)
            maxHeap.offer(minHeap.poll());
        else minHeap.offer(maxHeap.poll());
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
