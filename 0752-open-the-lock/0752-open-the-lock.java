class Solution {
    public int openLock(String[] deadends, String T) {
        /*
            
            Time: 
                O(N^2 * A^N + D), 
                where N is number of dials (4 in our case), 
                        A is number of alphabet (10 in our case), 
                        D is size of deadends.
                * There are 10^4 possible combinations => O(A^N)
                * To get neighbors, for each combination, we are looping 4 times (which is N) and in each iteration, there are substring operations which costs O(N) => O(N^2)
                * Total O(D) to create the hashset
            
            Space: O(A^N), in worst case equal to number of combinations.
        */
        
        
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));
        

        // edge case that we missed
        if(deadEnds.contains("0000"))
            return -1;
        
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visited.add("0000");
        
        int turns = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                String currPattern = q.poll();
                if(currPattern.equals(T))
                    return turns;
                
                for(int j=0;j<4;j++) {
                    String left = currPattern.substring(0, j);
                    String right = currPattern.substring(j+1);
                    
                    char c = currPattern.charAt(j);
                    
                    int up = (c - '0' + 1) % 10;
                    int down = (c - '0' - 1 + 10) % 10;
                        
                    String np1 = left + up + right;
                    String np2 = left + down + right;
                    
                    if(!deadEnds.contains(np1) && !visited.contains(np1)) {
                        visited.add(np1);
                        q.add(np1);
                    }
                    if(!deadEnds.contains(np2) && !visited.contains(np2)) {
                        visited.add(np2);
                        q.add(np2);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}