class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
            1. more frequent tasks should be picked up first
            2. less frequent tasks can be done in between while we are waiting for the next cycle for current task
        */
        
        // get the frequency of all the tasks
        int[] cnt = new int[26];
        for(char task : tasks)
            cnt[task - 'A']++;
        
        // process the highly frequent task first
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < 26; i++)
            if(cnt[i] > 0)
                pq.offer(cnt[i]);
        
        // A A A B B B , n = 2
        // - - - - - -
        // A B 1 A B 1 A B
        // time = 3
        int time = 0;
        while(!pq.isEmpty()) {
            int cn = n + 1; // number of tasks that can be done in between
            List<Integer> taskList = new ArrayList<>(); // list of tasks that needs to be picked again
            int taskCount = 0;
            while(!pq.isEmpty() && cn-- > 0) {
                int curr_task = pq.poll(); // do the curr task
                curr_task--; // remaining tasks of same type
                if(curr_task > 0) taskList.add(curr_task);
                taskCount++;
            }
            for(int task : taskList) pq.offer(task);
            time += (pq.size() == 0 ? taskCount : n + 1);
        }
        return time;
    }
}