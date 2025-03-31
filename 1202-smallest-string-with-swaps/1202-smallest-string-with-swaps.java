class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        /*
            Group the indices and their chars together to choose from
            s = dcab, pairs = [[0,3],[1,2]]
            group1 : 0, 3, <- b d
            group2 : 2, 1  <- a c <- we want to store the chars in group in lexi order
            
            To group the characters, I can use union find and create a parent mapping
            Map of
            
            parentGroupId : pq<Characters>
            
        */
        int n = s.length();
        UnionFind uf = new UnionFind();
        uf.makeSet(n); // O(V)
        
        for(int i = 0; i < pairs.size(); i++) { // O(E)
            uf.union(pairs.get(i).get(0), pairs.get(i).get(1)); // alpha(V)
        }
        
        Map<Integer, PriorityQueue<Character>> component_char = new HashMap<>();
        for(int i = 0; i < n ; i ++) {
            int p = uf.findSet(i);
            component_char.putIfAbsent(p, new PriorityQueue<>());
            component_char.get(p).offer(s.charAt(i));
        }
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n ; i++) {
            int p = uf.findSet(i);
            answer.append(component_char.get(p).poll());
        }
        return answer.toString();
    }
}

class Node {
    int index, rank;
    Node parent;
}

class UnionFind {
    
    private Map<Integer, Node> map ;
    
    UnionFind() {
        this.map = new HashMap<>();
    }
    
    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node();
            newNode.index = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
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
    
    public void union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == pB) return;
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank : pA.rank + 1;
        } else {
            pA.parent = pB;
            pB.rank ++;
        }
    }
}
