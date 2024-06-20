
class Solution {
    public int findLongestChain(int[][] pairs) {
        // Approch 1 : LIS
        // Approch 2 : greedy : sort with end why ? 
        /*
            If we sort with start, it might so happen that a pair that starts early and ends very late will
            come in the begining. That is what will create a problem.
        */
        
        int n = pairs.length;
        
        Arrays.sort(pairs, (p1, p2) -> {
            return p1[1] - p2[1];
        });
        
        int maxLength = 1, prev = pairs[0][1];
        
        for(int i = 1; i < n; i++) {
            if(pairs[i][0] > prev) {
                maxLength++;
                prev = pairs[i][1];
            }
        }
        
        return maxLength;
    }
}