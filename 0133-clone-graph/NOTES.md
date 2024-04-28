```
class Solution {
HashMap<Node, Node> map = new HashMap<>();
public Node cloneGraph(Node node) {
if(node == null) return null;
clone(node);
return map.get(node);
}
private Node clone(Node node) {
if(node == null) return null;
//
if(map.containsKey(node)) return map.get(node);
Node newNode = new Node(node.val, new ArrayList<Node>());
map.put(node, newNode);
for(Node child : node.neighbors) {
newNode.neighbors.add(clone(child));
}
return newNode;
}
}
```