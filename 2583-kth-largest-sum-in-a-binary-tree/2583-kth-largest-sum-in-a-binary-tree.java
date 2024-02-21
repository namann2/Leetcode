class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        // Using quick select
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Long> levelSums = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for(int i=0;i<size;i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            levelSums.add(sum);
        }
        int n = levelSums.size();
        k = n - k;
        if(k > n) return -1;
        return quickSelect(levelSums, 0, n-1, k);
    }
    private long quickSelect(List<Long> sums, int left, int right, int k) {
        if(left > right) return -1;
        long pivot = sums.get(right);
        int pi = partition(sums, left, right, pivot);
        if(pi == k) return sums.get(pi);
        else if(pi > k) return quickSelect(sums, left, pi-1, k);
        else return quickSelect(sums, pi+1, right, k);
    }
    private int partition(List<Long> sums, int left, int right, long pivot) {
        int i=left;
        while(left <= right) {
            if(sums.get(left) <= pivot) {
                long temp = sums.get(i);
                sums.set(i, sums.get(left));
                sums.set(left, temp);
                i++;
            } 
            left++;
        }
        return i-1;
    }
}