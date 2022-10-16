# Solution 1 : Brute Force
```
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if(n<3) return 0;
        int cnt = 0;
        for(int i=0;i<n-1;i++) {
            // for all the subarrays starting from i, check how many subarrays follow AP
            int diff = A[i+1] - A[i];
            for(int j=i+2;j<n;j++) {
                if(A[j] - A[j-1] == diff) cnt++;
                else break;
            }
        }
        return cnt;
    }
}
```


# Solution 2 : Dynamic Programming
```
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[]dp = new int[n];
        for(int i=2;i<n;i++) {
            if(A[i]-A[i-1] == A[i-1]-A[i-2])
                dp[i] = dp[i-1]+1;
        }
        
        int total = 0;
        for(int countOfAPEndingAtI : dp)
            total += countOfAPEndingAtI;
        
        return total;
    }
}

```
