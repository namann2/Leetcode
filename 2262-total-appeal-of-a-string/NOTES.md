# Solution 1 :
```
class Solution {
public long appealSum(String s) {
long A = 0, total = 0;
int[] lastOcc = new int[26];
Arrays.fill(lastOcc, -1);
// update the last occurence of each char
for(int i=0;i<s.length();i++) {
if(lastOcc[s.charAt(i)-'a'] == -1) {
A += i+1;
}
else {
A += (i - lastOcc[s.charAt(i)-'a']);
}
total += A;
lastOcc[s.charAt(i)-'a'] = i;
}
return total;
}
}
​
/*
a b b c a
0 1 2 3 4