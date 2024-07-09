class NodeHeightPair {
    int nodeVal, nodeHeight;
    public NodeHeightPair(int nodeVal, int nodeHeight) {
        this.nodeVal = nodeVal;
        this.nodeHeight = nodeHeight;
    }
}

class Solution {

    private HashMap<Integer, PriorityQueue<NodeHeightPair>> mp;
    private HashMap<Integer, Integer> nodeLevel;
    private HashMap<Integer, Integer> nodeHeight;
    
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] answer = new int[n];
        if(root == null)
            return answer;
        
        /*
            1. Find Height and Depth(Level) of every node in the tree
            2. At each Depth(Level), store the nodes with max two heights
            3. TODO : 
                3.1 Iterate over queries
                3.2 ...
        */
        
        mp = new HashMap<>();
        nodeLevel = new HashMap<>();
        nodeHeight = new HashMap<>();
        
        performOperation(root, 0);
        
        // System.out.println(nodeLevel);
        // System.out.println(nodeHeight);
        // System.out.println(mp);
        
        for(int i = 0; i < n; i++) {
            int removeNodeVal = queries[i];
            // we need to know what is the level of this node -> create a map
            int removeNodeValLevel = nodeLevel.get(removeNodeVal);
            
            if(mp.get(removeNodeValLevel).size() == 1)  // no cousin : height will be level - 1
                answer[i] = removeNodeValLevel - 1;
            else {
                // get max 2 heights on level
                NodeHeightPair secondMax = mp.get(removeNodeValLevel).remove();
                NodeHeightPair firstMax = mp.get(removeNodeValLevel).remove();
                
                if(firstMax.nodeVal != removeNodeVal) answer[i] = firstMax.nodeHeight + removeNodeValLevel;
                else if(secondMax.nodeVal != removeNodeVal) answer[i] = secondMax.nodeHeight + removeNodeValLevel;
                else answer[i] = removeNodeValLevel - 1;
                
                mp.get(removeNodeValLevel).offer(secondMax);
                mp.get(removeNodeValLevel).offer(firstMax);
            }
        }
        
        return answer;
    }
    
    private int performOperation(TreeNode root, int level) {
        if(root == null)
            return -1;
        
        mp.putIfAbsent(level, new PriorityQueue<>((p, q) -> {
            return p.nodeHeight - q.nodeHeight;
        }));
        
        nodeLevel.put(root.val, level);
        
        int left = performOperation(root.left, level + 1);
        int right = performOperation(root.right, level + 1);
        
        int currHeight = 1 + Math.max(left, right);
        NodeHeightPair p = new NodeHeightPair(root.val, currHeight);
        
        mp.get(level).offer(p);
        if(mp.get(level).size() > 2) mp.get(level).remove();
        
        nodeHeight.put(root.val, currHeight);
        return currHeight;
    }
}