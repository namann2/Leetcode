class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        Arrays.sort(connections, (c1, c2) -> {
            return c1[2] - c2[2];
        });
        
        int cost = 0;
        for(int[] connection : connections) {
            if(uf.union(connection[0], connection[1]))
                cost += connection[2];
        }
        return uf.getSize() == 1 ? cost : -1;
    }
}

class Node {
    int index, rank;
    Node parent;
}

class UnionFind {
    private HashMap<Integer, Node> map;
    private int size;
    UnionFind() {
        this.map = new HashMap<>();
        this.size = 0;
    }
    public void makeSet(int n) {
        for(int i = 1; i < n + 1 ; i ++) {
            Node newNode = new Node();
            newNode.index = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        this.size = n;
    }
    public int getSize() {
        return this.size;
    }
    public int findSet(int a) {
        return findSet(map.get(a)).index;
    }
    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newNode = findSet(node.parent);
        node.parent = newNode;
        return newNode;
    }
    public boolean union(int a,int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB) return false;
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
        size--;
        return true;
    }
}