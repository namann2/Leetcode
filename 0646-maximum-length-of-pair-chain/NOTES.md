#### LIS :
```
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> {
            if(p1[0] == p2[0]) return p1[1] - p2[1];
            return p1[0] - p2[0];
        });
        int pairsLength = pairs.length, maxLength = 0;
        int[] dp = new int[pairsLength];
        for(int pairEnd = 0; pairEnd < pairsLength; pairEnd ++) {
            for(int pairStart = 0; pairStart < pairEnd; pairStart ++) {
                // pairStart[0], pairStart[1]..... pairEnd[0], pairEnd[1]
                if(pairs[pairStart][1] < pairs[pairEnd][0] && dp[pairEnd] <= dp[pairStart]) {
                    dp[pairEnd] = dp[pairStart];
                }
            }
            dp[pairEnd] += 1;
            maxLength = Math.max(maxLength, dp[pairEnd]);
        }
        return maxLength;
    }
}
```

<hr>

#### Greedy : 
I sorted by `end` here as a general rule of thumb -
1. If we want to maximise result - we should sort by end. Reasoning - `Frees up the resource as early as possible for the next task.`
2. If we want to minimise result or merge things - we should sort by start. - `Processes events chronologically to handle overlaps.` and `Keeps mutually overlapping intervals adjacent to one another.`

Additionally, Rule of Thumb
1. If we sort by End Time (Ascending) $\rightarrow$ Iterate Forward (Left to Right).
2. If we sort by Start Time (Descending) $\rightarrow$ Iterate Backward (Right to Left).

```
class Solution {
    public int findLongestChain(int[][] pairs) {
        // sort by end because we want to maximum the length
        Arrays.sort(pairs, (p1, p2) -> {
            if(p1[1] == p2[1]) return p1[0] - p2[0];
            return p1[1] - p2[1];
        });
        int pairsLength = pairs.length, maxLength = 1, prevPair[] = pairs[0];
        for(int pair = 1; pair < pairsLength; pair ++) {
            // currPair[0]..currPair[1] ... lastPair[0]..lastPair[1]
            if(prevPair[1] < pairs[pair][0]) {
                prevPair = pairs[pair];
                maxLength++;
            }
        }
        return maxLength;
    }
}
```​
