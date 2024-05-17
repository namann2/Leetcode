class HitCounter {
    
    Deque<Integer> q;
    public HitCounter() {
        q = new ArrayDeque<>();
    }
    
    public void hit(int timestamp) {
        q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        purge(timestamp);
        return q.size();
    }
    
    private void purge(int ts) {
        while(!q.isEmpty() && ts - q.peekFirst() + 1 > 300) q.removeFirst();
    }
}

