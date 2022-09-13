The first solution that I came up with.
We can refactor the code with the submission.

```
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;
        return rangeSum(root, low, high);
    }
    
    private int rangeSum(TreeNode root, int l, int h) {
        if(root == null)
            return 0;
        
        int ans = 0, left = 0, right = 0;
				
        if(root.val >= l && root.val <= h) {
            ans += root.val;
            left += rangeSum(root.left, l, h, ans);
            right += rangeSum(root.right, l, h, ans);
        }
        else {
		if(root.val < l) 
			right += rangeSum(root.right, l, h, ans);
	        if(root.val > h)
			left += rangeSum(root.left, l, h, ans);
        }
	return ans + left + right;
    }
}

```
