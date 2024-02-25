class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        // map from factor to parent of a component of UF
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind();
        int n = nums.length;
        uf.makeSet(n);
        for(int i=0;i<n;i++) {
            int num = nums[i];
            for(int factor=2;factor*factor <= num; factor++) {
                if(num % factor != 0) 
                    continue;
                if(map.containsKey(factor)) {
                    uf.union(i, map.get(factor));
                } else {
                    map.put(factor, i);
                }
                while(num % factor == 0) 
                    num /= factor;
            }
            if (num > 1) { // num is a prime number
                if (map.containsKey(num))
                    uf.union(i, map.get(num));
                else
                    map.put(num, i);
            }
        }
        return uf.set == 1;
    }
}

class UnionFind {
    HashMap<Integer, Node> map;
    int set;
    
    UnionFind() {
        this.map = new HashMap<>();
        this.set = 0;
    }
    
    public void makeSet(int n) {
        for(int i=0;i<n;i++) {
            Node newNode = new Node();
            newNode.rank = 0;
            newNode.data = i;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        this.set = n;
    }

    private Node findSet(Node node) {
        if(node.parent == node)
            return node;
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
        }
        else {
            pA.parent = pB;
            pB.rank++;
        }
        this.set--;
    }
}

class Node {
    int rank;
    int data;
    Node parent;
}