class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        // construction of graph
        HashMap<String, Integer> email2Index = new HashMap<>();
        for(int i = 0; i <  n; i++) {
            int size = accounts.get(i).size();
            List<String> account = accounts.get(i);
            for(int j = 1; j < size; j++) { // 0th index is the name of the person having an acct
                String email = account.get(j);
                if(!email2Index.containsKey(email)) {
                    email2Index.put(email, i);
                } else {
                    uf.union( uf.findSet(email2Index.get(email)),  uf.findSet(i) );
                }
            }
        }
        
        // grouping emails by index
        HashMap<Integer, PriorityQueue<String>> validIndex2Email = new HashMap<>();
        for(String email : email2Index.keySet()) {
            int p = uf.findSet(email2Index.get(email)); // find the set of the current email
            if(!validIndex2Email.containsKey(p))
                validIndex2Email.put(p, new PriorityQueue<>());
            validIndex2Email.get(p).offer(email);
        }
        
        List<List<String>> mergedDetails =  new ArrayList<>();
        for(Integer id : validIndex2Email.keySet()) {
            PriorityQueue<String> emails =  validIndex2Email.get(id);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(id).get(0));
            while(!emails.isEmpty()) temp.add(emails.poll());
            mergedDetails.add(temp);
        }
        
        return  mergedDetails;
    }
}

class UnionFind {
    HashMap<Integer, Node> map;
    UnionFind() {
        this.map = new HashMap<>();
    }
    public int findSet(int val) {
        if(!map.containsKey(val))
            return -1;
        return findSet(map.get(val)).index;
    }
    private Node findSet(Node node) {
        if(node.parent == node)
            return node;
        Node newNode = findSet(node.parent);
        node.parent = newNode;
        return newNode;
    }
    public void makeSet(int n) {
        for(int i=0;i<n;i++) {
            Node newNode = new Node();
            newNode.index = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }
    public void union(int a, int b) {
        Node pA = map.get(a);
        Node pB = map.get(b);
        
        if(pA == pB)
            return;
        
        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank == pB.rank ? pA.rank + 1 : pA.rank;
        }
        else {
            pA.parent = pB;
            pB.rank ++;
        }
    }
}

class Node {
    int index;
    int rank;
    Node parent;
    Node(){}
}