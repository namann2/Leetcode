class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer = new ArrayList<>();
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        contructGraph(nodeToParentMap, root);
        nodeToParentMap.put(root, null);
        
        bfs(nodeToParentMap, target, k, answer);
        return answer;
    }
    
    private void bfs(Map<TreeNode, TreeNode> map, TreeNode target, int k, List<Integer> answer) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        int distance = 1;
        while(!q.isEmpty() && distance <= k) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && visited.add(curr.left)) q.add(curr.left);
                if(curr.right != null && visited.add(curr.right)) q.add(curr.right);
                if(map.get(curr) != null && visited.add(map.get(curr))) q.add(map.get(curr));
            }
            distance++;
        }
        
        while(!q.isEmpty()) answer.add(q.poll().val);
    }
    
    private void contructGraph(Map<TreeNode, TreeNode> map, TreeNode root) {
        if(root == null) return;
        
        if(root.left != null) map.put(root.left, root);
        if(root.right != null) map.put(root.right, root);
        
        contructGraph(map, root.left);
        contructGraph(map, root.right);
    }
}