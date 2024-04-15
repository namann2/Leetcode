class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n); // O(V)
        
        
        for(int[] edge : edges) { // E
            uf.union(edge[0], edge[1]); // alpha(n)
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) { // V
            Node node = uf.findSet(i); // V
            map.put(node.data, node.size);
        }
        
        if(map.size() == 1) return 0;
        
        long sum = 0;
        for(int num : map.values()) sum += num;
        
        long ans = 0;
        for(int num : map.values()) { // V
            sum -= num;
            ans += sum * num;
        }
        return ans;
        
        // TC : V + E * alpha(n) + V^2 + V
        // SC : V(uf->map) + V(map)
    }
}

class Node {
    int data, rank, size;
    Node parent;
    Node(int data, int rank, int size) {
        this.data = data;
        this.rank = rank;
        this.size = size;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    UnionFind() {
        map = new HashMap<>();
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node(i, 0, 1);
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }
    
    public Node findSet(int a) {
        return findSet(map.get(a));
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
            pA.size += pB.size;
        } else {
            pA.parent = pB;
            pB.rank = pB.rank + 1;
            pB.size += pA.size;
        }
        return true;
    }
}