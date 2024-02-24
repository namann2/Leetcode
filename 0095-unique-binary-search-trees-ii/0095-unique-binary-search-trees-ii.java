class Solution {
    Map<Pair<Integer, Integer>, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> answer = new ArrayList<>();
        if(n == 0) return answer;
        return constructBST(1, n);
    }
    private List<TreeNode> constructBST(int start, int end) {
        List<TreeNode> answer = new ArrayList<>();
        // base case
        if(start > end) {
            answer.add(null);
            return answer;
        }
        
        // main logic
        Pair p = new Pair(start, end);
        if(map.containsKey(p))
            return map.get(p);
        
        for(int i=start;i<=end;i++) {
            List<TreeNode> leftSubtree = constructBST(start, i-1);
            List<TreeNode> rightSubtree = constructBST(i+1, end);
            for(TreeNode left : leftSubtree) {
                for(TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    answer.add(root);
                    map.putIfAbsent(p, new ArrayList<>());
                    map.get(p).add(root);
                }
            }
        }
        return answer;
    }
}