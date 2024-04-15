class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.size;
    }
}

class Node {
    int data, rank;
    Node parent;
    Node(int data, int rank) {
        this.data = data;
        this.rank = rank;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    int size;
    UnionFind() {
        map = new HashMap<>();
        size = 0;
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node(i, i);
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        size = n;
    }
    
    private Node findSet(Node node) {
        if(node == null) return null;
        if(node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;
        return newParent;
    }
    
    public boolean union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB) return false;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank = pB.rank + 1;
        }
        size--;
        return true;
    }
}