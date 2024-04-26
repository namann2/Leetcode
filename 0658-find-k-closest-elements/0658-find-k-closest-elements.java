class Solution {
    public List<Integer> findClosestElements(int[] A, int k, int x) {
        PriorityQueue<int[]> q = new PriorityQueue<>((n1, n2) -> {
            if(n1[0] == n2[0]) return n2[1] - n1[1];
            return n2[0] - n1[0];
        });
        for(int num : A) {
            q.offer(new int[]{Math.abs(num -x), num});
            if(q.size() > k)
                q.poll();
        }
        
        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            answer.add(q.poll()[1]);
        }
        Collections.sort(answer);
        return answer;
    }
}