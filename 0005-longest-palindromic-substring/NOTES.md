#### way 1 : pepcoding

```
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][]dp = new boolean[n][n];
        int start = 0, end = 0;

        for(int g=0;g<n;g++) {
            int row = 0;
            for(int col=g;col<n;col++) {
                if(g == 0) {
                    dp[row][col] = true;
                } else if(g==1) {
                    dp[row][col] = s.charAt(row) == s.charAt(col);
                } else {
                    dp[row][col] = s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == true;
                }
                if(dp[row][col]) {
                    // gap is always increasing thus, we can directly update our indices
                    start = row;
                    end = col;
                }
                row++;
            }
        }
        
        return s.substring(start, end+1);
    }
}

```
				
#### way 2 : extended approach of [ https://leetcode.com/problems/palindromic-substrings/ ] / Expand from centre
        
way 2 : 
```
        String op = "";
        for(int i=0;i<s.length();i++) {
            int[] l1 = expandFromCenter(s, i, i);
            int[] l2 = expandFromCenter(s, i, i+1);
            
            if(l1[1]-l1[0] > op.length()) op = s.substring(l1[0]+1, l1[1]);
            if(l2[1]-l2[0] > op.length()) op = s.substring(l2[0]+1, l2[1]);
        }
        return op;
    }
    private int[] expandFromCenter(String s, int i, int j) {
        // we will break out of the loop once we find unequal characters.
        while(i>=0 && j<s.length()) {
            if(s.charAt(i) != s.charAt(j)) return new int[]{i,j};
            i--;
            j++;
        }
        return new int[]{i,j};
    }
```


#### way 3 : I am trying this approach but seems like this won't work here. I am not able to find the reason to it at the moment 

```
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        String p = new StringBuilder(s).reverse().toString();
        int max = 0, end = 0;
        for(int i=0;i<n+n-1;i++) {
            int fs = Math.max(0, n-1-i);
            int ss = Math.max(0, i-(n-1));
            
            int curr = 0;
            for(;fs<n && ss<n;fs++,ss++) {
                if(s.charAt(fs) == p.charAt(ss)) curr++;
                else curr = 0;
                if(curr > max) {
                    max = curr;
                    end = ss;
                }
            }
        }
        
        // System.out.println(start+" - "+end);
        return p.substring(end-max+1, end+1);
    }
}
```
