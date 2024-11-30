class Solution {
    public boolean containsCycle(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        
        UnionFind uf = new UnionFind();
        uf.makeSet(rows * cols);
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(j+1 < cols && grid[i][j] == grid[i][j+1]) {
                    if(uf.union(i * cols + j, (i * cols + (j+1))))
                        return true;
                }
                
                if(i+1 < rows && grid[i][j] == grid[i+1][j]) {
                    if(uf.union(i * cols + j, (i+1) * cols + j))
                        return true;
                }
            }
        }
        return false;
    }
}

class Node {
    int data, rank;
    Node parent;
    public Node(int data, int rank, Node parent) {
        this.data = data;
        this.rank = rank;
        this.parent = parent;
    }
}

class UnionFind {
    
    private Map<Integer, Node> map;
    
    public UnionFind() {
        this.map = new HashMap();
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node(i, 0, null);
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }
    
    public boolean union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB) return true; // cycle detected
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank > pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
        return false;
    }
    
    // helper functions
    
    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;
        return newParent;
    }
    
    public int findSet(int a) {
        return findSet(map.get(a)).data;
    }
}