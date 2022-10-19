class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] answer = new int[]{-100000, 100000};
        // int[] = {A[i], 0, i}
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2)->{
            return p1[0] - p2[0];
        });
        
        int K = nums.size();
        int max = 0;
        for(int i=0;i<K;i++) {
            int[] newElement = new int[]{nums.get(i).get(0), 0, i};
            max = Math.max(max, newElement[0]);
            pq.add(newElement);
        }
        
        while(!pq.isEmpty()) {
            int[] currElement = pq.poll();
            if(answer[1] - answer[0] + 1 > max - currElement[0] + 1) {
                answer[0] = currElement[0];
                answer[1] = max;
            }
            
            List<Integer> currList = nums.get(currElement[2]);
            
            if(currElement[1]+1 < currList.size()) {
                int cnum = currList.get(currElement[1]+1);
                max = Math.max(max, cnum);
                pq.add(new int[]{cnum, currElement[1]+1, currElement[2]});
            } 
            else break; // break since the list of smaller size is now finished and the decided range would suffice
        }
        return answer;
    }
}