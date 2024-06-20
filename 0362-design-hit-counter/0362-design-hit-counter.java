class HitCounter {

    private Deque<Integer> q;
    public HitCounter() {
        q = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peekFirst() >= 300) q.removeFirst();
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */