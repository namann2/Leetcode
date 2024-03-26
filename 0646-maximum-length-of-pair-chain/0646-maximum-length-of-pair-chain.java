class Solution {
    public int findLongestChain(int[][] pairs) {
        // sorting with end, since we want to increase the 
        // length of longest increasing sequence which
        // depends upon the end number. [s,e] the smallest the 
        // end of a pair in the starting, more pairs can be 
        // considered.
        Arrays.sort(pairs, (p1, p2) -> {
            return p1[1] - p2[1];
        });
        
        int length = 0, n = pairs.length;
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(pairs[i][0] > prev) {
                length++;
                prev = pairs[i][1];
            }
        }
        return length;
    }
}