class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<>();
        
        if(root == null)
            return answer;
        
        TreeMap<Integer, List<int[]>> map = new TreeMap<>(); // left to right
        traverse(root, map, 0, 0); 
        
        for(int hdis : map.keySet()) {
            List<Integer> temp = new ArrayList<>();
            for(int[] nodeVal : map.get(hdis))
                temp.add(nodeVal[0]);
            answer.add(temp);
        }
        return answer;
    }
    
    private void traverse(TreeNode root, TreeMap<Integer, List<int[]>> map, int hdis, int level) {
        if(root == null)
            return;
        
        map.putIfAbsent(hdis, new ArrayList<>());
        map.get(hdis).add(new int[]{root.val, level});
        
        traverse(root.left, map, hdis - 1, level + 1);
        traverse(root.right, map, hdis + 1, level + 1);
        
        List<int[]> list = map.get(hdis);
        Collections.sort(list, (l1, l2) -> {
            if(l1[1] == l2[1]) 
               return 0;
            else if(l1[1] < l2[1])
                return -1;
            return 1;
        });
    }
}