class Solution {
    public boolean equationsPossible(String[] equations) {
        if(equations == null || equations.length == 0)
            return true;
        int n = equations.length;
        UnionFind uf = new UnionFind();
        uf.makeSet(26);
        
        
        Set<Integer> indices = new HashSet<>();
        for(int i=0;i<n;i++) {
            String equation = equations[i];
            char op1 = equation.charAt(0),
                sym1 = equation.charAt(1),
                sym2 = equation.charAt(2),
                op2 = equation.charAt(3);
            
            if(sym1 == '=' && sym2 == '=') {
                uf.union(op1-'a', op2-'a');
                indices.add(i);
            }
        }
        
        for(int i=0;i<n;i++) {
            if(indices.add(i)) {
                String equation = equations[i];
                char op1 = equation.charAt(0),
                    sym1 = equation.charAt(1),
                    sym2 = equation.charAt(2),
                    op2 = equation.charAt(3);
                
                Node s1 = uf.findSet(op1-'a');
                Node s2 = uf.findSet(op2-'a');
                if(s1.parent == s2.parent)
                    return false;
            }
        }
        return true;
    }
}

class Node {
    int data, rank;
    Node parent;
}

class UnionFind {
    private Map<Integer, Node> map;
    private int set;
    
    UnionFind() {
        map = new HashMap<>();
    }
    
    public void makeSet(int n) {
        for(int i=0;i<n;i++) {
            Node newNode = new Node();
            newNode.data = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        this.set = n;
    }
    
    public Node findSet(int val) {
        return find(map.get(val));
    }
    
    private Node find(Node node) {
        if(node == null || node.parent == node)
            return node;
        Node newNode = find(node.parent);
        node.parent = newNode;
        return newNode;
    }
    
    public boolean union(int a, int b) {
        Node pA = find(map.get(a));
        Node pB = find(map.get(b));
        
        if(pA== pB)
            return false;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank : pA.rank + 1;
        }
        else {
            pA.parent = pB;
            pB.rank += 1;
        }
        
        this.set-- ;
        return true;
    }
}