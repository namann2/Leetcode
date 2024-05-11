class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // sort by column -> left to right
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
    private void traverse(TreeNode root, int hdis, int level, TreeMap<Integer, List<int[]>> map) {
        if(root == null) return;
        
        map.putIfAbsent(hdis, new ArrayList<>());
        map.get(hdis).add(new int[]{level, root.val});
        
        traverse(root.left, hdis - 1, level + 1, map);
        traverse(root.right, hdis + 1, level + 1, map);
        
        List<int[]> currList = map.get(hdis);
        
        Collections.sort(currList, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            else if(a[0] < b[0]) return -1;
            return 1;
        });
    }
}