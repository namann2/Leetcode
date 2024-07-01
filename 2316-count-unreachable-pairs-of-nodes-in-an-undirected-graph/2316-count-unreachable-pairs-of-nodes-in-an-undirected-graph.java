class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        for(int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        
        return getCount(uf, n);
    }
    
    private long getCount(UnionFind uf, int n) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            Node parent = uf.findSet(i);
            map.putIfAbsent(parent.data, parent.size);
        }
        
        long distinctComponents = map.size();
        
        if(distinctComponents == 1) return 0l;
        
        long allNodes = n * 1L;
        
        long count = 0l; 
        for(int parent : map.keySet()) {
            long remainingNodes = allNodes - map.get(parent);
            count += remainingNodes * map.get(parent);
            allNodes = remainingNodes;
        }
        
        return count;
    }
}

class Node {
    int data, rank, size;
    Node parent;
    
    public Node(){}
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
            newNode.size = 1;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }
    
    public Node findSet(int a) {
        return findSet(map.get(a));
    }
    private Node findSet(Node node) {
        if(node == null || node.parent == node)
            return node;
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
            pA.rank = pA.rank == pB.rank ? pA.rank + 1 : pA.rank;
            pA.size += pB.size;
        } else {
            pA.parent = pB;
            pB.rank ++;
            pB.size += pA.size;
        }
    }
    
}