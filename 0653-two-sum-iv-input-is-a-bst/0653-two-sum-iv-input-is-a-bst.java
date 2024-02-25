class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode curr1 = root, curr2 = root;
        
        while(curr1 != null) {
            stack1.push(curr1);
            curr1 = curr1.left;
        }
        while(curr2 != null) {
            stack2.push(curr2);
            curr2 = curr2.right;
        }
        
        // we need to find two elements hence both the stack should be non-empty to find us the result
        while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() != stack2.peek()) {
            curr1 = stack1.peek();
            curr2 = stack2.peek();
            
            int csum = curr1.val + curr2.val;
            
            if(csum == k) return true;
            else if(csum > k) {
                curr2 = stack2.pop();
                curr2 = curr2.left;
                while(curr2 != null) {
                    stack2.push(curr2);
                    curr2 = curr2.right;
                }
            } else {
                curr1 = stack1.pop();
                curr1 = curr1.right;
                while(curr1 != null) {
                    stack1.push(curr1);
                    curr1 = curr1.left;
                }
            }
        }
        return false;
    }
}