/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        if(p == null && q == null) return null;
        Node a = p, b = q;
        while(a != b) {
            a = a.parent != null ? a.parent : q;
            b = b.parent != null ? b.parent : p;
        }
        return a;
    }
}