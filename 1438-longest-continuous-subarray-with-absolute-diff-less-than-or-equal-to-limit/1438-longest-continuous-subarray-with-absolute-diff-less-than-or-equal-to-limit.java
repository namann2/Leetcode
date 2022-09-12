class Solution {
    public int longestSubarray(int[] A, int limit) {
        // TC : O(N), SC : O(N)
        // pre-requisite : Sliding Window Maximum
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();
        
        int begin = 0, end = 0, n = A.length, maxLength = 0;
        while(end < n) {
            while(!min.isEmpty() && min.peekLast() > A[end]) min.removeLast();
            while(!max.isEmpty() && max.peekLast() < A[end]) max.removeLast();
            min.addLast(A[end]);
            max.addLast(A[end]);
            while(max.peekFirst() - min.peekFirst() > limit && begin < end) {
                if(min.peekFirst() == A[begin]) min.removeFirst();
                if(max.peekFirst() == A[begin]) max.removeFirst();
                begin++;
            }
            maxLength = Math.max(maxLength, end-begin+1);
            end++;
        }
        return maxLength;
    }
}