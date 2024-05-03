class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Queue<Integer> q = new LinkedList<>();
        boolean[]visited = new boolean[n];
        
        int cnt = 1;
        visited[0] = true;
        q.offer(0);
        
        while(!q.isEmpty()) {
            int currRoom = q.poll();
            List<Integer> nextRoomKey = rooms.get(currRoom);
            for(int key : nextRoomKey) {
                if(visited[key]) continue;
                visited[key] = true;
                cnt++;
                q.offer(key);
            }
        }
        
        return cnt == n;
    }
}