}
if(map.size() >= maxCapacity) {
remove(dT.prev);
}
Node newNode = new Node(key, value);
insert(newNode);
}
private void remove(Node node) {
map.remove(node.key);
// H - 1 - 2 - 3 - T
node.prev.next = node.next;
node.next.prev = node.prev;
}
private void insert(Node node) {
map.put(node.key, node);
// H - 1 - 2 - T, 4
Node tmp = dH.next;
dH.next = node;
node.prev = dH;
node.next = tmp;
tmp.prev = node;
}
}
```