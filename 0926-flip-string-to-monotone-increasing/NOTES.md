## ​Logic : 

If s[i - 1] = '1', then we have dp[i] = dp[i - 1], since we can always append a character '1' to the end of a monotone increasing string and it's still monotone increasing.

If s[i - 1] = '0', let's consider whether we flip it or not.

If we don't flip it, we have to flip all the '1's in s before it.
If we flip it, then we can treat it as the above case where s[i - 1] = '1' with one more flip.



```
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int cnt = 0;
        int ones = 0;
        for(int i = 0 ;i < n ; i ++) {
            int num = s.charAt(i)-'0';
            if(num == 1) ++ones;
            else cnt = Math.min(cnt + 1, ones);
        }
        return cnt;
    }
}

```

# TL;DR
```
int flips = 0, ones = 0;
        // flips -> 0 -> 1
        // ones -> # of 1 uptil that point
        
        for(char ch : s.toCharArray()) {
            if(ch == '1') ++ones;
            else {
               flips = Math.min(flips+1, ones); 
            }
        }
        return flips;
```

****

# Explanation : 
```
class Solution {
    public int minFlipsMonoIncr(String s) {
        // flips denotes the number of flips we have made so far
        int flips = 0;
        // this variables denotes the number of 1s we have seen so far
        int count_ones = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // calculating the number of flips required to make the string[0:i] monotone increasing
            if(s.charAt(i) == '1') {
                // 1 is ok, if the last digit is 1, it will make a monotonic increasing array
                ++count_ones;
            } else {
                // 0 is problem. We have 2 choices here. 
                // Either flip this this 0 to 1, in this case our num flips will increase by 1
                // Or we can let this 0 be as is, but then we have to flip all the previous 1s to 0, this is why we need the count_one variable
                flips = Math.min(flips + 1, count_ones);
            }
        }
        return flips;
    }
}
```
