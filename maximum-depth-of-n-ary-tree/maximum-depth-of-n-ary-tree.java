class Solution {
    public int maxDepth(Node root) {
        if(root == null) return 0;
        return maxDepthUtil(root);
    }
    private int maxDepthUtil(Node root) {
        if(root == null) return 0;
        int h = 0;
        for(Node child : root.children) {
            h = Math.max(h, maxDepthUtil(child));
        }
        
        return 1 + h;
    }
}