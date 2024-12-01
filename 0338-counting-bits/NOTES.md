## Another Approach based on Observation

```
class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        // Observation
        for(int i = 1; i < n+1; i++) {
            if(i % 2 == 0) ans[i] = ans[i/2];
            else ans[i] = ans[i/2] + 1;
        }
        return ans;
    }
}
```
