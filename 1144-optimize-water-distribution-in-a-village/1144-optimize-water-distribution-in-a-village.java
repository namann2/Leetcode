class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        // order basis of minimum cost
        PriorityQueue<int[]> pq = new PriorityQueue<>((p,q) -> {
            return p[2] - q[2];
        });

        for(int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i+1, wells[i]});
        }

        int pipeLength = pipes.length;
        for(int i = 0; i < pipeLength; i++) {
            pq.offer(new int[]{pipes[i][0], pipes[i][1], pipes[i][2]});
        }

        UnionFind uf = new UnionFind();
        uf.makeSet(n+1);

        int minCost = 0;
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int house1 = curr[0], house2 = curr[1], costToWater = curr[2];
            if(uf.union(house1, house2)) {
                minCost += costToWater;
            }
            if(uf.components == 1) break;
        }
        return minCost;
    }
}

class Node {
    int data, rank;
    Node parent;
}

class UnionFind {
    Map<Integer, Node> map;
    int components;

    public UnionFind() {
        this.map = new HashMap<>();
        this.components = 0;
    }

    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node node = new Node();
            node.data = i;
            node.rank = 0;
            node.parent = node;
            map.put(i, node);
        }
        this.components = n;
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
            pA.rank = pA.rank > pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
        return true;
    }
}