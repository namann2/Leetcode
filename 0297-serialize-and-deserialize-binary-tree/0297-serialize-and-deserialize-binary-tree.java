public class Codec {

    private static final String DEL = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return DEL;
        
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        
        sb.append(",");
        sb.append(serialize(root.left));
        sb.append(",");
        sb.append(serialize(root.right));
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        for(String d : data.split(",")) q.add(d);
        return construct(q);
    }
    
    private TreeNode construct(Queue<String> q) {
        if(!q.isEmpty() && q.peek().equals(DEL)) {
            q.remove();
            return null;
        }
        
        int val = Integer.valueOf(q.remove());
        TreeNode newNode = new TreeNode(val);
        newNode.left = construct(q);
        newNode.right = construct(q);
        return newNode;
    }
}
