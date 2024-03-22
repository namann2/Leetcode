# Approach using TreeMap : TC : `(M log N)`

```
class Solution {
    public int[] answerQueries(int[] A, int[] q) {
        int m = q.length;
        int[]answer = new int[m];
        
        Arrays.sort(A);
        int n = A.length;
        int[]ps = new int[n];
        ps[0] = A[0];
        
        for(int i=1;i<n;i++)
            ps[i] += ps[i-1] + A[i];
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<n;i++) {
            map.put(ps[i], i);
        }
        
        for(int i=0;i<m;i++) {
            Integer idx = map.floorKey(q[i]);
            if(idx != null) 
                answer[i] = map.get(idx)+1;
        }
        return answer;
    }
}
```

# Approach 2 : Use less space by explicitly coding the binary Search logic : 

```
class Solution {
    public int[] answerQueries(int[] A, int[] q) {
        int m = q.length;
        int[]answer = new int[m];
        // since subsequence, order does not matter
        Arrays.sort(A);
        int n = A.length;
        for(int i=1;i<n;i++)
            A[i] += A[i-1];
        
        for(int i=0;i<m;i++) {
            int idx = binarySearch(A, q[i]);
            if(idx != -1) 
                answer[i] = idx+1;
        }
        return answer;
    }
    private int binarySearch(int[]A, int sum) {
        int n = A.length;
        int start = 0, end = n-1, ans = -1;
        while(start <= end) {
            int m = start + (end - start)/2;
            if(A[m] <= sum) {
                ans = m;
                start = m + 1;
            } else end = m - 1;
        }
        return ans;
    }
}
```
