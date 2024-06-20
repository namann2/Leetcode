Helpful Resource for Approch 1 : https://www.youtube.com/watch?v=z5L5xYorZC8

## Approch1 : 

To minimise the number of operations, we need to try to pick elements in order of 3. If not, then we can choose to pick in pairs.

```
  class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int cnt = 0;
        for(int freq : map.values()) {
            if(freq == 1) return -1;
            else if(freq % 3 == 0) {
                cnt += freq / 3;
            } else if(freq % 3 == 1) { // 7 = 7-2 = 5-2 = 3
                // (count - 4) / 3 + 2 = count/3 - 4/3 + 2 = count/3 + 1
                // is this generalised ?
                // let's check : 10 => 3 + 1 = 4 (is it ? 10-2=8-2=6 => 2 + 2)
                cnt += freq / 3 + 1;
            } else if(freq % 3 == 2) { // 8 = 8-2 = 6  = 2 + 1
                // (count - 2) / 3 + 1 = c/3 - 2/3 + 1 = c/3 + 1/3 = (c + 1)/3 
                // is this generalised ?
                // let's check : 14 = 14-2 = 12 / 3 = 4 + 1 = 5
                cnt += (freq + 1) / 3;
            }
        }
        return cnt;
    }
}
```

## Approch 2 : 

This is refactoring of above code, but I would still stick to Approch 1
```
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        int operations = 0;
        for(int num : count.keySet()) {
            int freq = count.get(num);
            if(freq == 1) return -1;
            operations += freq / 3 + (freq % 3 > 0 ? 1 : 0);
        }
        return operations;
    }
}
```
