class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) 
            return answer;
        
        TreeNode curr = root;
        while(curr != null) {
            if(curr.left != null) {
                TreeNode runner = curr.left;
                while(runner.right != null && runner.right != curr) {
                    runner = runner.right;
                }
                if(runner.right == null) {
                    runner.right = curr;
                    answer.add(curr.val);
                    curr = curr.left;
                } else {
                    runner.right = null;
                    curr = curr.right;
                }
            } else {
                answer.add(curr.val);
                curr = curr.right;
            }
        }
        return answer;
    }
}