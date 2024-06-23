class Solution {
    public int maxChunksToSorted(int[] A) {
        int n = A.length;
        int max = Integer.MIN_VALUE;

        int chunk = 0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, A[i]);
            if(i == max) chunk++;
        }
        return chunk;
    }
}