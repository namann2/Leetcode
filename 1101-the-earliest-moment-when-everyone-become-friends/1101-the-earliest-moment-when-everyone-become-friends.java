class Solution {
    public int earliestAcq(int[][] logs, int n) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        Arrays.sort(logs, (l1, l2) -> {
            return l1[0] - l2[0];
        });
        
        for(int[] log : logs) {
            if(uf.union(log) && uf.size == 1) return log[0];
        }
        
        return -1;
    }
}

class Node {
    int data, rank;
    Node parent;
    
    public Node() {}
    
    public Node(int data, int rank, Node parent) {
        this.data = data;
        this.rank = rank;
        this.parent = parent;
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
            Node newNode = new Node(i, 0, null);
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        size = n;
    }
    
    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;
        return newParent;
    }
    
    public boolean union(int[] log) {
        int ts = log[0], node1 = log[1], node2 = log[2];
        Node pA = findSet(map.get(node1));
        Node pB = findSet(map.get(node2));
        
        if(pA == pB) return false;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
        this.size--;
        return true;
    }
}