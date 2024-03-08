class Solution {
    public int minJumps(int[] A) {
        // TC : O(n), SC : O(n)
        int n = A.length;
        if(n == 1) return 0;
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> valueIndex = new HashMap<>();
        
        for(int i = 0;i < n; i++) {
            valueIndex.putIfAbsent(A[i], new ArrayList<>());
            valueIndex.get(A[i]).add(i);
        }
        
        q.offer(0);
        visited.add(0);
        int steps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i ++) {
                int currIndex = q.poll();
                
                if(currIndex == n-1) 
                    return steps;

                int left = currIndex - 1;
                int right = currIndex + 1;
                
                if(valueIndex.get(A[currIndex]) != null) {
                    for(int index : valueIndex.get(A[currIndex])) {
                        if(visited.add(index)) q.offer(index);
                    }
                    valueIndex.remove(A[currIndex]);
                }
                
                if(left >= 0 && visited.add(left)) q.offer(left);
                if(right <= n-1 && visited.add(right)) q.offer(right);
            }
            steps++;
        }
        return -1;
    }
}