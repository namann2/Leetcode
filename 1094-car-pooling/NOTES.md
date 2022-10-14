```
class Solution {
public boolean carPooling(int[][] trips, int capacity) {
int[] capacityAtEachPoint = new int[10001];
for(int[] trip : trips) {
capacityAtEachPoint[trip[1]] += trip[0];
capacityAtEachPoint[trip[2]] += -trip[0];
}
// TC : Max(n, 1001), SC : O(1001) = O(1)
​
int currentCapacity = 0;
for(int i=0;i<10001;i++) {
currentCapacity += capacityAtEachPoint[i];
if(currentCapacity > capacity)
return false;
}
return true;
}
}
​
/*
2   5  -2
1 2 3 4 5 6 7 8 9
---------
---------
*/