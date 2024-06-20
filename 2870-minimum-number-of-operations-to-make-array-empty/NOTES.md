// Helpful : https://www.youtube.com/watch?v=z5L5xYorZC8
```
class Solution {
public int minOperations(int[] nums) {
Map<Integer, Integer> map = new HashMap<>();
for(int num : nums)
map.put(num, map.getOrDefault(num, 0)+1);
int cnt = 0;
for(int num : map.keySet()) {
int freq = map.get(num);
if(freq == 1) return -1;
/*
if freq is divisible by 2 but not by 3, we will pick 2 numbers
and since, any even number that is not divisible by 3 and is
divisible by 2, is of the form 2n + 2, for eg :  8, 14 etc..
so if we take 2 numbers from them, it becomes possible to
pick 3 numbers.
*/
if(freq % 2 == 0 && freq % 3 != 0) {
cnt++;
freq-=2;
}
// if remain numbers can be picked up 3, else pick a pair.
cnt += freq / 3 + (freq % 3 > 0 ? 1 : 0);
}
return cnt;
}
}
```