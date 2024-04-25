class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> {
            return p1[2] - p2[2];
        });
        int n = points.length;
        for(int i = 0; i < n; i++) {
            int[] p1 = points[i];
            for(int j = i + 1; j < n; j++) {
                int[] p2 = points[j];
                pq.offer(new int[]{i, j, md(p1, p2)});
            }
        }
        
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        
        int cost = 0;
        while(!pq.isEmpty()) {
            int[] pair = pq.poll();
            if(uf.union(pair[0], pair[1]))
                cost += pair[2];
            if(uf.getSize() == 1) 
                break;
        }
        return cost;
    }
    private int md(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}

class Node {
    int index, rank;
    Node parent;
}

class UnionFind {
    private Map<Integer, Node> map;
    private int size;
    UnionFind() {
        map = new HashMap<>();
        size = 0;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n ; i ++) {
            Node newNode = new Node();
            newNode.parent = newNode;
            newNode.index = i;
            newNode.rank = 0;
            map.put(i, newNode);
        }
        size = n;
    }
    
    public int findSet(int a) {
        return findSet(map.get(a)).index;
    }
    
    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
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
            pB.rank ++;
        }
        size -= 1;
        return true;
    }
}