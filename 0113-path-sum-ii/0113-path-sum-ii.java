class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        allPaths(root, result, new ArrayList<>(), targetSum);
        return result;
    }
    
    private void allPaths(TreeNode root, List<List<Integer>> result, List<Integer> temp, int target) {
        // base case
        if(root == null) return;
        if(isLeaf(root) && target == root.val) {
            temp.add(root.val);
            result.add(new ArrayList<>(temp));
            temp.remove(temp.size()-1);
            return;
        }
        // main logic
        temp.add(root.val);
        allPaths(root.left, result, temp, target - root.val);
        allPaths(root.right, result, temp, target - root.val);
        temp.remove(temp.size()-1);
    }
    
    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}