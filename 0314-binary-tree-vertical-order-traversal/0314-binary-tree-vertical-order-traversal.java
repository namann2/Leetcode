class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root == null) return answer;
        
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // left to right
        traverse(root, 0, 0, map);
        
        for(int key : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for(int[] val : map.get(key)) {
                temp.add(val[1]);
            }
            answer.add(temp);
        }
        return answer;
    }
    
    private void traverse(TreeNode node, int hdis, int level, TreeMap<Integer, List<int[]>> map) {
        // base case
        if(node == null) return;
        
        // main logic
        map.putIfAbsent(hdis, new ArrayList<>());
        map.get(hdis).add(new int[]{level, node.val});
        
        traverse(node.left, hdis - 1, level + 1, map);
        traverse(node.right, hdis + 1, level + 1, map);
        
        List<int[]> currList = map.get(hdis);
        
        Collections.sort(currList, (a, b) -> {
            if(a[0] == b[0]) 
                return 0;
            else if(a[0] < b[0]) return -1;
            return 1;
        });
        
    }
}