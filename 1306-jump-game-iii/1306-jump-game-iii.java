class Solution {
    public boolean canReach(int[] A, int start) {
        if(A[start] == 0) return true;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        int n = A.length;
        
        q.offer(start);
        visited.add(start);
        
        while(!q.isEmpty()) {
            int currIndex = q.poll();
            
            if(A[currIndex] == 0) return true;
            
            int left = currIndex - A[currIndex];
            int right = currIndex + A[currIndex];
            
            if(left >= 0 && visited.add(left)) q.offer(left);
            if(right <= n-1 && visited.add(right)) q.offer(right);
        }
        return false;
    }
}