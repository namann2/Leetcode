class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, Integer> emailsToIndex = new HashMap<>();
        
        int n = accounts.size();
        
        UnionFind uf = new UnionFind();
        uf.makeSet(n);
        
        // step1
        for(int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            int size = account.size();
            for(int j = 1; j < size; j++) {
                String email = account.get(j);
                if(!emailsToIndex.containsKey(email)) {
                    emailsToIndex.put(email, i);
                } else {
                    int a = uf.findSet(emailsToIndex.get(email));
                    int b = uf.findSet(i);
                    uf.union(a, b);
                }
            }
        }
        
        // step2
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        
        for(String email : emailsToIndex.keySet()) {
            int index = emailsToIndex.get(email);
            int unifiedParent = uf.findSet(index);
            mergedAccounts.putIfAbsent(unifiedParent, new ArrayList<>());
            mergedAccounts.get(unifiedParent).add(email);
        }
        
        // step3
        for(int unifiedParent : mergedAccounts.keySet()) {
            String nameOfPerson = accounts.get(unifiedParent).get(0);
            List<String> emailIds = mergedAccounts.get(unifiedParent);
            Collections.sort(emailIds);
            List<String> currList = new ArrayList<>();
            currList.add(nameOfPerson);
            currList.addAll(emailIds);
            answer.add(currList);
        }
        
        return answer;
    }
}

class Node {
    int data, rank;
    Node parent;
    
    public Node() {
        
    }
}

class UnionFind {
    
    private Map<Integer, Node> map;
    
    public UnionFind() {
        map = new HashMap<>();    
    }
    
    public void makeSet(int n) {
        
        for(int i = 0; i < n; i++) {
            Node newNode = new Node();
            newNode.data = i;
            newNode.rank = 0;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
        
    }
    
    public int findSet(int a) {
        return findSet(map.get(a)).data;
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
        
        System.out.println("Unified : "+a +" :: "+b);
        return true;
    }
}

/*

johnsmith@mail.com : [0, 1]
john_newyork@mail.com : [0]
john00@mail.com : [1]
mary@mail.com : [2]
johnnybravo@mail.com : [3]


[0,1](0) : John
[2] : Mary
[3] : John


John : [johnsmith@mail.com, john_newyork@mail.com, john00@mail.com]



Optimisation : We can upgrade from having a String : List<Integer> to String : Integer and go ahead with merge or unify the 
emails while constructing the graph itself.

1. Construct the graph and unify()
2. Merge
*/