# Solution 1 :

`TC: O(n + q * log n)`, where `n` is the length of input string and `q` is the length is `Q`.

`SC: O(n)`

```
class Solution {
    public int[] platesBetweenCandles(String s, int[][] Q) {
        int n = s.length();
        int[]ps = new int[n+1];
        TreeSet<Integer> plates = new TreeSet<>();
        ps[0] = s.charAt(0) == '*' ? 1 : 0;
        if(s.charAt(0) == '|') plates.add(0);
        for(int i=1;i<n;i++) {
            char ch = s.charAt(i);
            if(ch == '*') ps[i] = ps[i-1] + 1;
            else {
                ps[i] = ps[i-1];
                plates.add(i);
            }
        }
        
        int[] ans = new int[Q.length];
        int idx = 0;
        for(int[]q : Q) {
            Integer higher = plates.ceiling(q[0]);
            Integer lower = plates.floor(q[1]);
            if(lower == null || higher == null) {
                idx++;
                continue;
            }
            int val = ps[lower] - ps[higher];
            ans[idx++] = val >= 0 ? val : 0;
        } 
        return ans;
    }
}
```

# Solution 2 : 

`TC: O(n) + O(q)`, where `n` is the length of input string and `q` is the length of `Q`

`SC: O(n)`

```
class Solution {
    public int[] platesBetweenCandles(String s, int[][] Q) {
        int n = s.length();
        int[]ps = new int[n+1];
        ps[0] = s.charAt(0) == '*' ? 1 : 0;

        for(int i=1;i<n;i++) {
            char ch = s.charAt(i);
            if(ch == '*') ps[i] = ps[i-1] + 1;
            else {
                ps[i] = ps[i-1];
            }
        }
        
        // store the plates on left and right
        int[]L = new int[n];
        int plate = 0;
        for(int i=0;i<n;i++) {
            if(s.charAt(i) == '|')
                plate = i;
            L[i] = plate;
        }
        
        int[]R = new int[n];
        plate = n-1;
        for(int i=n-1;i>=0;i--) {
            if(s.charAt(i) == '|')
                plate = i;
            R[i] = plate;
        }
        
        
        int[] ans = new int[Q.length];
        int idx = 0;
        for(int[]q : Q) {
            int higher = R[q[0]];
            int lower = L[q[1]];
            int val = ps[lower] - ps[higher];
            ans[idx++] = val >= 0 ? val : 0;
        } 
        return ans;
    }
}
```
