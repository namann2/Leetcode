Check pepcoding video if in doubt

## Approach 1 :  Sorting 

#### TC : O(n log n) , SC : O(n)

```

class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        Arrays.sort(nums);
        int[] lcs = new int[n];
        int answer = 1;
        lcs[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            if(nums[i] + 1 == nums[i+1]) lcs[i] = lcs[i+1] + 1;
            else if(nums[i] == nums[i+1]) lcs[i] = lcs[i+1];
            else lcs[i] = 1;
            answer = Math.max(answer, lcs[i]);
        }
        return answer;
    }
}

```

## Approach 2 : HashMap

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        /*
            map indicates that whether current element
            can be the start of a LCS
        */
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        // first pass
        for(int num : nums){
            map.put(num, true);
        }
        
        // second pass : check if current element can be the 
        // start of a LCS, one way to check this is
        // to check if current element is a part of a sequence
        
        for(int num : nums) {
            if(map.containsKey(num-1)) map.put(num, false);
        }
        
        // third pass
        int maxLength = 0;
        for(int num : nums) {
            if(!map.get(num)) continue;
            int local = 1;
            while(map.containsKey(num++ + 1)) local++;
            maxLength = Math.max(maxLength, local);
        }
        return maxLength;
    }
}
```

## HashSet

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;
        
        Set<Integer> numbers = new HashSet<>();
        for(int num : nums) numbers.add(num);
        
        int answer = 1;
        
        for(int num : nums) {
            // why ? bcz then num will become the part of a sequence
            if(numbers.contains(num-1))  
                continue; 
            int local = 1;
            while(numbers.contains((num++) + 1)) local++;
            answer = Math.max(answer, local);
        }
        return answer;
    }
}
```

## Union Find

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

```
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0 || n == 1) return n;

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
```
