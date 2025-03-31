class Solution {
    public int largestComponentSize(int[] nums) {
        /*
            Given
                there are n nodes 
                undirected graph b/w u and v, if gcf(u, v) > 1
            Solution : 
            - we need to find the size of largest group of nodes. This relates to UF.
            - O(n^2) is doable solution but the constraints limit us to make solution more performant.
            - How to improve TC ?

            4 - 2, 4
            6 - 2, 3
            15 - 3, 5 ,15
            35 - 5, 7, 35

            Create a map of factors and add the numbers to the same group. Now, it is an observation that we do 
            not actually need all factors, prime factors would suffice the need for this.

            Idea : Get prime factors of all the numbers we are given.
            Create the makeSet for all the prime factors.
            While iterating over the factors of each number if the factor is prime increase the size of the group  
        */
        int n = nums.length;
        int maxNumber = Arrays.stream(nums).max().getAsInt();
        UnionFind uf = new UnionFind();
        uf.makeSet(maxNumber); // O(maxNumber)
        
        // seive of erathnosis to find prime numbers : O(n * log(log(n)))
        boolean[] prime = new boolean[maxNumber + 1];
        Arrays.fill(prime, true);
        
        for(int i = 2; i * i <= maxNumber; i++) {
            if(prime[i]) {
                for(int j = i * i; j <= maxNumber; j += i) {
                    prime[j] = false;
                }
            }
        }
        
        // group numbers by their prime factors : O(n * log n * alpha(log n))
        for(int num : nums) {
            for(int factor = 2; factor * factor <= num; factor ++) {
                if(num % factor == 0) {
                    if(prime[factor]) uf.union(num, factor);
                    if(prime[num / factor]) uf.union(num, num / factor);
                }
            }
        }
        
        int largestComponent = 0;
        Map<Integer, Integer> parentGroup = new HashMap<>();
        for(int num : nums) {
            Node numParent = uf.findSet(num); 
            int groupCount = parentGroup.getOrDefault(numParent.data, 0) + 1;
            parentGroup.put(numParent.data, groupCount);
            largestComponent = Math.max(largestComponent, groupCount);
        }
        return largestComponent;
    }
}

class Node {
    int data, rank;
    Node parent;
    
    public Node() {}
    
    public Node(int data, int rank) {
        this.data = data;
        this.rank = rank;
        this.parent = this;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    
    public UnionFind() {
        this.map = new HashMap<>();
    }
    
    // making set equal to the prime factors
    public void makeSet(int n) {
        for(int i = 0; i <= n; i++) {
            Node newNode = new Node(i, 0);
            map.put(i, newNode);
        }
    }
    
    public Node findSet(int a) {
        return findSet(map.get(a)).parent;
    }
    
    public Node findSet(Node node) {
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
            pA.rank = pA.rank == pB.rank ? pA.rank + 1 : pA.rank;
        } else {
            pA.parent = pB;
        }
    }
}
