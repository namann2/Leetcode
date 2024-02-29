```
class Solution {
public int numDecodings(String s) {
if(s==null || s.length() == 0) return 0;
if(s.charAt(0) == '0') return 0;
int n = s.length();
int[]dp=new int[n];
dp[0] =1;
for(int i=1;i<n;i++) {
int ch = s.charAt(i)-'0';
if(ch>0 && ch<10) dp[i] = dp[i-1];
int num = Integer.valueOf(s.substring(i-1,i+1));
if(num > 9 && num < 27)
if(i>=2) dp[i] += dp[i-2];
else dp[i]+=1;
}
return dp[n-1];
}
}
​
// 1223
```