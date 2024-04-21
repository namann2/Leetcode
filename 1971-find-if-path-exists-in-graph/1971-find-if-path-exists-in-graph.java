class Solution {
    // Let n be the number of nodes and m be the number of edges.
    // TC : O(m * alpha(n)) ~ O(E * alpha(V))
    // SC : O(V)
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return uf.findSet(source) == uf.findSet(destination);
    }
}

class Node {
    int data, rank;
    Node parent;
    Node(int data, int rank, Node parent) {
        this.data = data;
        this.rank = rank;
        this.parent = parent;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    UnionFind() {
        map = new HashMap<>();
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node node = new Node(i, i, null);
            node.parent = node;
            map.put(i, node);
        }    
    }
    
    public int findSet(int a) {
        return findSet(map.get(a)).data;
    }
    
    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newNode = findSet(node.parent);
        node.parent = newNode;
        return newNode;
    }
    
    public void union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB) return;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank + 1 : pA.rank;
        } else {
            pA.parent = pB;
            pB.rank += 1;
        }
    }
}