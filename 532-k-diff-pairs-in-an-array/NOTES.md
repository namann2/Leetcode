# Solution 1: 
```
class Solution {
    public int findPairs(int[] A, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : A)
            map.put(i, map.getOrDefault(i, 0)+1);
        
        int count = 0;
        for(int e : map.keySet()) {
            count += k>0 && map.get(e+k) != null || k == 0 && map.get(e)>1 ? 1 : 0;
        }
        return count;
    }
}
```

# Solution 2: 
```
class Solution {
    public int findPairs(int[] A, int k) {
        Arrays.sort(A);
        int l , r ,n = A.length;

        HashSet<String> set = new HashSet<>();
        for(int i=0;i<n-1;i++) {
            l = i;
            r = i+1;
            if(A[r]-A[l] > k) continue; // if diff > k, means the number is greater. Hence, we can not find any more pair for `A[l]`
            
            while(r<n && A[r]-A[l] <= k) {
                if(A[r]-A[l] == k)
                    set.add(A[l]+"-"+A[r]);
                r++;
            }
        }
        return set.size();
    }
}
```
