class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if(root == null) return answer;

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left != null) {
                // 1. constructing the thread
                TreeNode runner = curr.left;
                while(runner != null && runner.right != null && runner.right != curr) {
                    runner = runner.right;
                }
                if(runner.right == null) {
                    // printing the while creating the threads, this is because we create threads only once
                    // but visit the node multiple times.
                    answer.add(curr.val); 
                    runner.right = curr;
                    curr = curr.left;
                } else { // threaded path is already there from runner, hence, we need to break it
                    curr = curr.right;
                    runner.right = null;
                }
            } else {
                answer.add(curr.val);
                curr = curr.right;
            }
        }
        return answer;
    }
}