class Solution {
    public int maxChunksToSorted(int[] A) {
        /*
            1 2 3 4 | 5 6 7
            [1...4]..
            For a increasing straight line , (Max at i) < (Min of I + 1)...
            i.e [1..4] max =4 , [5..7] min in 5 ,
            So , If Max < Min , then there is no element on the right side , who belongs on the left side as per above observation.
            if Max > Min, it means , there is some element on the right side, who belongs on the left, so we CANNOT create a chunk.
        
        */
        int n = A.length;
        int[] maxOnLeft = new int[n];
        int[] minOnRight = new int[n];
        
        maxOnLeft[0] = A[0];
        for(int i = 1; i < n; i++)
            maxOnLeft[i] = Math.max(maxOnLeft[i-1], A[i]);
        
        minOnRight[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--)
            minOnRight[i] = Math.min(minOnRight[i+1], A[i]);
        
        int chunks = 1; // we need in minimum atleast 1 chunk
        for(int i = 0; i < n-1; i++)
            if(maxOnLeft[i] <= minOnRight[i+1]) chunks++;
        
        return chunks;
    }
}