OLD TIMES : 😆
See Back To Back SWE lecture on this ->  basic idea ( do not consider the code implementation of his, it is complex and indeed lengthy )
​
The code is simple if you understood the logic behind the problem. Otherwise, see Nick White code video for this
​
# Solution :
​
```
class Node {
int key, value;
Node prev, next;
Node(int key, int value) {
this.key = key;
this.value = value;
}
}
class LRUCache {
private Node dH, dT;
private int maxCapacity = 0;
private HashMap<Integer, Node> map;
public LRUCache(int capacity) {
dH = new Node(-1,-1);
dT = new Node(-1,-1);
dH.next = dT;
// H - 1 - 2 - T, 4