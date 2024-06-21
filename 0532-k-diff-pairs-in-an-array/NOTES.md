# Solution :
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
​
# Solution :
```
class Solution {
public int findPairs(int[] A, int k) {
Arrays.sort(A);
int l , r ,n = A.length;
​
HashSet<String> set = new HashSet<>();