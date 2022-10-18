```
class Solution {
    public int rob(TreeNode root) {
        if(root == null) return 0;
        
        return robUtil(root, new HashMap<TreeNode, Integer>());
    }
    private int robUtil(TreeNode root, HashMap<TreeNode, Integer> cache) {
        if(root == null) return 0;
        
        if(cache.containsKey(root))
            return cache.get(root);
        
        int include = root.val;
        if(root.left!=null)
            include += robUtil(root.left.left, cache) + robUtil(root.left.right, cache);
        
        if(root.right!=null)
            include += robUtil(root.right.left, cache) + robUtil(root.right.right, cache);
        
        int exclude = robUtil(root.left, cache) + robUtil(root.right, cache);
        
        
        cache.put(root, Math.max(include, exclude));
        return Math.max(include, exclude);
    }
}
```
