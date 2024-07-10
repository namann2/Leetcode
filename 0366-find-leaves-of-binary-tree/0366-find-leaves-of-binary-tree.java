class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        findLeaves(root, answer);
        return answer;
    }
    
    private int findLeaves(TreeNode root, List<List<Integer>> answer) {
        if(root == null) return 0;
        
        int left = findLeaves(root.left, answer);
        int right = findLeaves(root.right, answer);
        
        int currHeight = 1 + Math.max(left, right);
        
        if(answer.size() < currHeight) 
            answer.add(new ArrayList<>());
        
        answer.get(currHeight - 1).add(root.val);
        return currHeight;
    }
}