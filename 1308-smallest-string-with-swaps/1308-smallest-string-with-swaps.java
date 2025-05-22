class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UnionFind uf = new UnionFind();
        uf.makeSet(n);

        for(List<Integer> pair : pairs) {
            uf.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> g = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int parent = uf.findSet(i);
            g.putIfAbsent(parent, new PriorityQueue<>());
            g.get(parent).offer(s.charAt(i));
        }

        StringBuilder smallestString = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int parent = uf.findSet(i);
            smallestString.append(g.get(parent).poll());
        }

        return smallestString.toString();
    }
}

class Node {
    int data, rank;
    Node parent;
}

class UnionFind {
    private Map<Integer, Node> map;
    
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
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));

        if(pA == pB) return;

        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank > pB.rank ? pA.rank : pA.rank ++;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
    }
}