```
class Solution {
public int countPairs(int[] A) {
HashMap<Integer, Integer> countMap = new HashMap<>();
int mod = (int)Math.pow(10, 9) + 7;
long res = 0;
for(int a : A) {
for(int i=0;i<=21;i++) {
int x = (int)Math.pow(2, i);
int b = x - a;
if(!countMap.containsKey(b))
continue;
res += countMap.get(b);
res %= mod;
}
countMap.put(a, countMap.getOrDefault(a, 0)+1);
}
return (int)res;
}
}
​
/*
e + e = e
o + o = e