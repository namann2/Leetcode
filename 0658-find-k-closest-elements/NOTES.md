// Solution 4 :
Binary Search. : TODO
​
****
​
// Solution 3 :
```
class Solution {
public List<Integer> findClosestElements(int[] A, int k, int x) {
List<Integer> result = new ArrayList();
PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
if(a==b) return Integer.compare(a, b);
return Integer.compare(Math.abs(a-x), Math.abs(b-x));
});
for(int i : A)
pq.add(i);
while(k > 0) {
result.add(pq.poll());
k--;
}
/*
---o---o------------o-----------x------
^   ^            ^