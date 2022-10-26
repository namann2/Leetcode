Basic understanding is working of remainders.
If k = 5, then 6 % 5 = 1, which also means (6 + 5) % 5 = 1. So you use a hash map to check if you have seen that remainder before. 
If yes, then you know between both indexes, it is 5 (i.e. (6 + 5) - 6 = 5)

# Code : 
```
class Solution {
    public boolean checkSubarraySum(int[] A, int k) {
        if(k==0) return false;
        int n = A.length;
        int ps = 0;
        int begin = 0, end = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder -> index that we first saw for this remainder
        while(end < n) {
            ps += A[end]++;
            int remainder = ps % k;
            if(map.containsKey(remainder)) {
                if(end - map.get(remainder) >= 2) return true;
            }
            else map.put(remainder, end);
            end++;
        }
        return false;
    }
}
```

[23,2,4,6,7]
[23,25,29,35,42]
[5, 1, 5, 5, 0]
[0, 6, 10]
