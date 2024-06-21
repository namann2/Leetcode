class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        int m = tasks.length;
        // get the frequency of each task
        for(int i = 0; i < m; i++)
            count[tasks[i]-'A']++;
        
        // max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b, a);
        });
        
        for(int i = 0; i < 26; i++) 
            if(count[i] > 0) 
                pq.offer(count[i]);
        
        /*
            A A A B B B, n = 2
            { A : 1, B : 1 }
            
            A B _ A B _ A B 
            q = A : 0, B : 0
            interval = 2(t) + 1(c) + 2(t) + 1(c) + 2(t)
        */
        int intervals = 0;
        while(!pq.isEmpty()) {
            int cycle = n + 1; // tasks that can be done in current cycle
            int taskCount = 0;
            Deque<Integer> q = new ArrayDeque<>();
            while(!pq.isEmpty() && cycle-- > 0) {
                int currTask = pq.poll();
                currTask--;
                if(currTask > 0) q.offer(currTask);
                taskCount++;
            }
            while(!q.isEmpty()) pq.offer(q.removeFirst());
            intervals += pq.isEmpty() ? taskCount : n + 1; // (n + 1 ideally equals = taskCount + cycle )
        }
        return intervals;
    }
}