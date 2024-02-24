class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr1 = root1, curr2 = root2;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        
        while(curr1 != null || !stack1.isEmpty() || curr2 != null || !stack2.isEmpty()) {
            while(curr1 != null) {
                stack1.push(curr1);
                curr1 = curr1.left;
            }
            
            while(curr2 != null) {
                stack2.push(curr2);
                curr2 = curr2.left;
            }
            
            if((!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().val <= stack2.peek().val) ||
              stack2.isEmpty() && !stack1.isEmpty()) {
                curr1 = stack1.pop();
                result.add(curr1.val);
                curr1 = curr1.right;
            } else {
                curr2 = stack2.pop();
                result.add(curr2.val);
                curr2 = curr2.right;
            }
        }
        return result;
    }
}