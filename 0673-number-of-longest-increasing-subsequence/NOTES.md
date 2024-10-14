```
class Solution {
    public int findNumberOfLIS(int[] A) {
        int n=A.length;
        int[]dp=new int[n];
        int[]cnt=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(cnt,1);
        int LIS=1;
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(A[i]>A[j]) {
                    if(dp[j]+1==dp[i]) {cnt[i]+=cnt[j];}
                    else if(dp[j]+1>dp[i]) {
                        dp[i]=dp[j]+1;
                        cnt[i]=cnt[j];
                    }
                }
            }
            LIS = Math.max(LIS, dp[i]);
        }
        
        int c=0;
        for(int i=0;i<n;i++)
            c+=(dp[i]==LIS ? cnt[i] : 0);
        return c;
    }
}
```
