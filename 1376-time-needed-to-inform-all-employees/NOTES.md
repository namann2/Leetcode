```
class Solution {
    public int numOfMinutes(int n, int headId, int[] manager, int[] informTime) {
        if(n == 1) // only one person who is the head is there
            return 0;
        
        HashMap<Integer, Queue<Integer>> mapSub = new HashMap<>();
        for(int i=0;i<n;i++) {
            mapSub.putIfAbsent(manager[i], new LinkedList<>());
            mapSub.get(manager[i]).add(i);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{headId, 0});// time taken to reach the info till curr node
        
        // since it is a tree, we do not need a visited array
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int currManager = curr[0], currTime = curr[1]; // time taken to reach the info till curr node
                time = Math.max(time, currTime);
                
                if(!mapSub.containsKey(currManager)) continue; // not every node would be a manager
                
                for(int subs : mapSub.get(currManager)) {
                    q.add(new int[]{subs, currTime + informTime[currManager]});
                }
            }
        }
        return time;
    }
}
```
