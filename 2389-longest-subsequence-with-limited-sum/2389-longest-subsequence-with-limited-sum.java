class Solution {
    public int[] answerQueries(int[] A, int[] q) {
        int m = q.length;
        int[]answer = new int[m];
        // since subsequence, order does not matter
        Arrays.sort(A);
        int n = A.length;
        int[]ps = new int[n];
        ps[0] = A[0];
        for(int i=1;i<n;i++)
            ps[i] += ps[i-1] + A[i];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++) {
            map.put(ps[i], i);
        }
        
        for(int i=0;i<m;i++) {
            Integer idx = map.floorKey(q[i]);
            if(idx != null) 
                answer[i] = map.get(idx)+1;
        }
        return answer;
    }
}