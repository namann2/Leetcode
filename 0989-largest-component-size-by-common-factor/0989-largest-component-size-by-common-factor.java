class Solution {
    public int largestComponentSize(int[] nums) {
        // get prime numbers
        int n = nums.length, maxNum = 0;
        for(int num : nums) maxNum = Math.max(num, maxNum);
        boolean[] isPrime = new boolean[maxNum + 1];
        getPrimeNumbers(isPrime, maxNum + 1);
        
        UnionFind uf = new UnionFind();
        uf.makeSet(maxNum + 1);
        // map of prime factors with list of numbers
        unifyFactors(uf, nums, isPrime);

        Map<Integer, List<Integer>> g = new HashMap<>();
        int largestComponent = 0;
        for(int num : nums) {
            Node parentNode = uf.findSet(num);
            int parent = parentNode.data, size = parentNode.size;
            g.putIfAbsent(parent, new ArrayList<>());
            g.get(parent).add(num);
            largestComponent = Math.max(largestComponent, g.get(parent).size());
        }
        return largestComponent;
    }

    /* helper function */
    private void getPrimeNumbers(boolean[] isPrime, int maxNum) {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i < maxNum; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j < maxNum; j += i) {
                    isPrime[j] = false;
                }       
            }
        }
    }

    private void unifyFactors(UnionFind uf, int[] nums, boolean[] isPrime) {
        for(int num : nums) {
            for(int factor = 2; factor * factor <= num; factor++) {
                if(num % factor == 0) {
                    if(isPrime[factor]) uf.union(num, factor);
                    if(isPrime[num / factor]) uf.union(num, num / factor);
                }
            }
        }
    }
}

class Node {
    int data, rank, size;
    Node parent;
}

class UnionFind {
    private Map<Integer, Node> map;

    public UnionFind() {
        this.map = new HashMap<>();
    }

    public void makeSet(int n) {
        for(int i = 0; i < n; i++) {
            Node newNode = new Node();
            newNode.data = i;
            newNode.rank = 0;
            newNode.size = 1;
            newNode.parent = newNode;
            map.put(i, newNode);
        }
    }
    
    public Node findSet(int a) {
        return findSet(map.get(a));
    }

    private Node findSet(Node node) {
        if(node == null || node.parent == node) return node;
        Node newParent = findSet(node.parent);
        node.parent = newParent;
        return newParent;
    }

    public void union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));

        if(pA == pB) return;

        if(pA.rank >= pB.rank) {
            pB.parent = pA;
            pA.rank = pA.rank > pB.rank ? pA.rank : pA.rank + 1;
            pA.size += pB.size;
        } else {
            pA.parent = pB;
            pB.rank++;
        }
    }
}