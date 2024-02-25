class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        /*
            TC : O(N^2) -> O(N log N) -> O(N)
            1. O(N^2) -naive approach -> go to each subarray and find the max. Make it current root 
                        and proceed the construction of children
            2. O(N log N) - segement/fenwick tree
            3. O(N) - cartesian tree -> Optimal usage of monotonic stack
        */
        Stack<TreeNode> stack = new Stack<>();
        for(int num : nums) {
            TreeNode node = new TreeNode(num);
            while(!stack.isEmpty() && stack.peek().val < num) {
                node.left = stack.pop();
            }
            if(!stack.isEmpty() && stack.peek().val > num) {
                stack.peek().right = node;
            }
            stack.push(node);
        }
        
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }

        return root;
    }
}