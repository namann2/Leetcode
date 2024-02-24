class Solution {
    Integer prev = null;
    int count = 0;
    int maxFreq = 0;
    List<Integer> result = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        prev = root.val;
        iterate(root);
        int n = result.size();
        int[] ans = new int[n];
        for(int i=0;i<n;i++) ans[i] = result.get(i);
        return ans;
    }
    private void iterate(TreeNode root) {
        if(root == null) return;
        iterate(root.left);
        if(prev != null) {
            if(prev == root.val) ++count;
            else count = 1;
        }
        if(count == maxFreq) {
            result.add(root.val);
        } else if(count > maxFreq) {
            result.clear();
            maxFreq = count;
            result.add(root.val);
        }
        prev = root.val;
        iterate(root.right);
    }
}