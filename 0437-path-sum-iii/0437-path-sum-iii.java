class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        
        return (int)pathSum(root, 0l, targetSum, map);
    }
    private long pathSum(TreeNode root, Long csum, int k, Map<Long, Long> map) {
        if(root == null) return 0;
        
        long ans = 0;
        csum += root.val;
        
        if(map.containsKey(csum - k))
            ans += map.get(csum - k);
        
        map.put(csum, map.getOrDefault(csum, 0l) + 1l);
        
        long L = pathSum(root.left, csum, k, map);
        long R = pathSum(root.right, csum, k, map);
        
        map.put(csum, map.get(csum) - 1);
        if(map.get(csum) == 0) map.remove(csum);
        
        return ans + L + R;
    }
}