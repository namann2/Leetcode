class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        /*
            I have implemented the uf a bit differently here.
            for a component structure, I have made the largest 
            element as the parent of the component.
            For this, I required rank so that I can represent the largest element, hence
            rank of a node is the data/value of the node itself.
            
            Checked, If current element is a part of any sequence.
            We can also follow 
            https://leetcode.com/problems/longest-consecutive-sequence/discuss/166544/Union-Find-Thinking-Process
            This has default union find, but it checks,
            if current element can be the part of a sequence or it marks the start of a new sequence.
        */
        UnionFind uf = new UnionFind();
        uf.makeSet(nums, n);
        
        int maxLength = 1;
        for(int num : nums) {
            int size = uf.union(num, num - 1);
            maxLength = Math.max(maxLength, size);
        }
        return maxLength;
    }
}


class Node {
    int data, rank, size;
    Node parent;
    Node(int data, int rank) {
        this.data = data;
        this.rank = rank;
    }
}

class UnionFind {
    Map<Integer, Node> map;
    UnionFind() {
        this.map = new HashMap<>();
    }
    
    public void makeSet(int[]nums, int n) {
        for(int i=0;i<n;i++) {
            if(map.containsKey(nums[i])) continue;
            Node newNode = new Node(nums[i], nums[i]);
            newNode.parent = newNode;
            newNode.size = 1;
            map.put(nums[i], newNode);
        }
    }
    
    public Node findSet(int a) {
        Node node = map.get(a);
        return findSet(node);
    }
    
    private Node findSet(Node node) {
        if(node == null) return null;
        Node nodeParent = node.parent;
        if(nodeParent == node) return node;
        node.parent = findSet(nodeParent);
        return node.parent;
    }
    
    public int union(int a, int b) {
        Node pA = findSet(map.get(a));
        Node pB = findSet(map.get(b));
        
        if(pA == null || pB == null) return -1;
        
        if(pA == pB) return pA.size;

        if(pA.rank > pB.rank) {
            pB.parent = pA;
            pA.size += pB.size;
            return pA.size;
        } else {
            pA.parent = pB;
            pB.size += pA.size;
            return pB.size;
        }
    }
}