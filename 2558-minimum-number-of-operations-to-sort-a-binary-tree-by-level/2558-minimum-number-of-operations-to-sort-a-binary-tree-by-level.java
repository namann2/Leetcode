class Solution {
    public int minimumOperations(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 0;

        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int swapOperations = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            List<Pair<TreeNode, Integer>> currLevel = new ArrayList<>();
            int index = 0;
            for(int i = 0; i < size; i++) {
                Pair currPair = q.poll();
                TreeNode currNode = (TreeNode)currPair.getKey();
                if(currNode.left != null) q.offer(new Pair(currNode.left, index++));
                if(currNode.right != null) q.offer(new Pair(currNode.right, index++));
                currLevel.add(currPair);
            }
            swapOperations += getSwapOperations(currLevel);
        }
        return swapOperations;
    }

    private int getSwapOperations(List<Pair<TreeNode, Integer>> currLevel) {
        // sorted array
        Collections.sort(currLevel, (p1, p2)->{
            return p1.getKey().val - p2.getKey().val;
        });

        int i = 0, n = currLevel.size(), count = 0;
        while(i < n) {
            Pair<TreeNode, Integer> currPair = currLevel.get(i);
            int currPosition = currPair.getValue();
            if(currPosition == i) i++;
            else {
                swap(currLevel, i, currPosition); // i -> correct position, currPosition is the index where element currently is
                count++;
            }
        }
        return count;
    }

    private void swap(List<Pair<TreeNode, Integer>> currLevel, int i, int j) {
        Pair<TreeNode, Integer> temp = currLevel.get(i);
        currLevel.set(i, currLevel.get(j));
        currLevel.set(j, temp);
    }
}