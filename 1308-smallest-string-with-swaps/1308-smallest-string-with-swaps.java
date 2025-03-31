class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind();
        uf.makeSet(n);

        for(List<Integer> pair : pairs) {
            int a = uf.findSet(pair.get(0));
            int b = uf.findSet(pair.get(1));
            uf.union(a, b);
        }

        Map<Integer, PriorityQueue<Character>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int key = uf.findSet(i);
            g.putIfAbsent(key, new PriorityQueue<>());
            g.get(key).offer(ch);
        }

        StringBuilder smallestString = new StringBuilder();
        for(int i = 0; i < n; i++) {
            smallestString.append(g.get(uf.findSet(i)).poll());
        }
        
        return smallestString.toString();
    }
}

/* UnionFind */
class Node {
    int data, rank;
    Node parent;
}

class UnionFind {

    Map<Integer, Node> map;

    public UnionFind() {
        this.map = new HashMap<>();
    }

    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node();
            newNode.data = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }

    public int findSet(int a) {
        return findSet(map.get(a)).data;
    }

    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;
        return newParent;
    }

    public void union(int a, int b) {
        Node pA = map.get(a) == null ? null : findSet(map.get(a));
        Node pB = map.get(b) == null ? null : findSet(map.get(b));

        if(pA == pB) return;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank > pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
    }
}