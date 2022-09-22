```
class Solution {
public Node lowestCommonAncestor(Node p, Node q) {
if(p.parent == q.parent) return p.parent;
// consider them two lists
Node a = p, b = q;
while(a!=b) {
a = a == null ? q : a.parent;
b = b == null ? p : b.parent;
}
return a;
}
}
```