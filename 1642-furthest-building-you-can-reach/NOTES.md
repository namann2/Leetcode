# Allocate Ladders First :
```
public int furthestBuilding(int[] h, int bricks, int ladders) {
// right of the bat, i know this is a greedy problem. Somewhat similar to the
// number of refuel stops.
var allocateLadder = new PriorityQueue<Integer>();
int n = h.length;
for(int i=0;i<n-1;i++) {
int climb = h[i+1] - h[i];
if(climb <= 0) continue;
// if the climb is positive, store the location of a ladder to re-allocate it afterwards if necessary
allocateLadder.add(climb);
if(allocateLadder.size() <= ladders) continue;
// if ladders are less then, we need to re-allocate the earlier position with bricks
bricks -= allocateLadder.poll();
if(bricks < 0) return i;
}
return n-1;
}
```