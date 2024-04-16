```
class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                uf.union(stones, i, j);
            }
        }
        return n - uf.ufs;
        // return uf.getSize();
    }
}

class Node {
    int data, rank, size;
    Node parent;
    Node(int data, int rank) {
        this.data = data;
        this.rank = rank;
        this.size = 1;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    int ufs;
    UnionFind() {
        this.map = new HashMap<>();
        ufs = 0;
    }
    
    // public int getSize() {
    //     int stones_removed = 0;
    //     Set<Integer> visitedComponent = new HashSet<>();
    //     for(int index : map.keySet()) {
    //         Node parent = findSet(map.get(index));
    //         if(parent != null && visitedComponent.add(parent.data)) 
    //             stones_removed += parent.size - 1;
    //     }
    //     return stones_removed;
    // }
    
    public void makeSet(int n) {
        for(int i=0;i<n;i++) {
            Node newNode = new Node(i, i);
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        ufs = n;
    }
    
    private Node findSet(Node node) {
        if(node == null) return null;
        if(node.parent == node)
            return node;
        Node newNode = findSet(node.parent);
        node.parent = newNode;
        return newNode;
    } 
    
    public boolean union(int[][] stones, int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB || !canUnify(stones[a], stones[b])) return false;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank + 1 : pA.rank;
            pA.size += pB.size;
        } else {
            pA.parent = pB;
            pB.rank++;
            pB.size += pA.size;
        }
        ufs--;
        return true;
    }
    
    private boolean canUnify(int[] x, int[] y) {
        return x[0] == y[0] || x[1] == y[1];
    }
}
​```
