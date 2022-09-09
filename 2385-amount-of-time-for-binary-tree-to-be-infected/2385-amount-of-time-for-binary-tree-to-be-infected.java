class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if(root == null)
            return 0;
        
        Map<TreeNode, TreeNode> nodeParent = new HashMap<>();
        preorder(root, nodeParent);
        nodeParent.put(root, null);
        
        return infectionTime(start, nodeParent);
    }
    
    private int infectionTime(int start, Map<TreeNode, TreeNode> parentMap) {
        TreeNode src = null;
        
        for(TreeNode node : parentMap.keySet()) 
            if(node.val == start) {
                src = node;
                break;
            }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(src);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(src);
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && visited.add(curr.left)) q.add(curr.left);
                if(curr.right != null && visited.add(curr.right)) q.add(curr.right);
                
                TreeNode currParent = parentMap.get(curr);
                if(currParent != null && visited.add(currParent)) q.add(currParent);
            }
            time++;
        }
        
        return time - 1;
    }
    
    private void preorder(TreeNode root, Map<TreeNode, TreeNode> map) {
        if(root == null) return;
        
        if(root.left != null) map.put(root.left, root);
        if(root.right != null) map.put(root.right, root);
        
        preorder(root.left, map);
        preorder(root.right, map);
    }
}