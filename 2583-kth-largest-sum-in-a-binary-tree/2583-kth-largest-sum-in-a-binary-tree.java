/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 
 1 2 3 4 5
 2nd largest = 4
 minHeap of size 2
 
 4 5
 */
class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            pq.add(sum);
            if(pq.size() > k) pq.poll();
        }
        if(pq.size() < k) return -1;
        return pq.peek();
    }
}