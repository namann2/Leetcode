class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        Deque<Integer> deq = new ArrayDeque<>();
        
        q.offer(root);
        int currLevel = 0;
        
        List<Integer> level = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                deq.offer(curr.val);
            }
            while(!deq.isEmpty()) {
                if(currLevel % 2 == 0) level.add(deq.removeFirst());
                else level.add(deq.removeLast());
            }
            currLevel++;
            result.add(new ArrayList<>(level));
            level.clear();
        }
        return result;
    }
}