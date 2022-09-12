class Solution {
    public int[] maxSlidingWindow(int[] A, int k) {
        // template question
        Deque<Integer> q = new LinkedList<>();
        int n = A.length;
        int[] maxWindow = new int[n-k+1];
        int idx = 0, begin = 0, end = 0;
        while(end < n) {
            while(!q.isEmpty() && q.peekLast() < A[end]) q.removeLast();
            q.addLast(A[end]);
            if(end-begin+1 == k) {
                maxWindow[idx++] = q.peekFirst();
                if(!q.isEmpty() && q.peekFirst() == A[begin]) q.removeFirst();
                begin++;
            }
            end++;
        }
        return maxWindow;
    }
}