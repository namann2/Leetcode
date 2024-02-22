class Solution {
    public List<TreeNode> allPossibleFBT(int n) {

        if(n % 2 == 0)
            return new ArrayList<>();
        Map<Integer, List<TreeNode>> cache = new HashMap<>();
        return constructFBT(cache, n);
    }
    private List<TreeNode> constructFBT(Map<Integer, List<TreeNode>> cache, int n) {
        // base condition
        if(n == 1) {
            TreeNode newNode = new TreeNode(0);
            List<TreeNode> temp = new ArrayList<>();
            temp.add(newNode);
            return temp;
        }
        
        if(cache.containsKey(n))
            return cache.get(n);
        // main logic
        List<TreeNode> result = new ArrayList<>();
        
        for(int i=1;i<n;i+=2) {
            List<TreeNode> leftSubtree = constructFBT(cache, i);
            List<TreeNode> rightSubtree = constructFBT(cache, n-i-1);
            for(TreeNode left : leftSubtree) {
                for(TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        cache.put(n, result);
        return result;
    }
}