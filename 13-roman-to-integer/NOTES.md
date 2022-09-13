```
class Solution {
public int romanToInt(String s) {
Map<Character, Integer> map = new HashMap<>();
map.put('I', 1);
map.put('V', 5);
map.put('X', 10);
map.put('L', 50);
map.put('C', 100);
map.put('D', 500);
map.put('M', 1000);
int n = s.length();
int N = map.get(s.charAt(n-1));
for(int i=n-2;i>=0;i--) {
int curr = map.get(s.charAt(i));
int next = map.get(s.charAt(i+1));
if(curr < next) N -= curr;
else N += curr;
}
return N;
}
}
```
​
# Dry Run :
CMXCIV
​
500 + 10 + 101
DXCI -> we check whether the current index is correct How ?
​
1. if decreasing sequence A[i] >= A[i+1] then A[i] is at correct position(pick & plce)
move to A[i+1]
2. else subtract A[i+1] - A[i], move to A[i+2];
*/
​
DXCI -> we check whether the current index is correct How ?