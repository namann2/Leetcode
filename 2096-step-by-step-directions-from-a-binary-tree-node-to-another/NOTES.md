```
class Solution {
public String getDirections(TreeNode root, int s, int d) {
if(root == null) return "";
StringBuilder st = new StringBuilder(), dt = new StringBuilder();
// step1 : find LCA
TreeNode lca = findLCA(root, s, d);
// step2 : find path from LCA
getPathFromLCA(lca, s, st);
getPathFromLCA(lca, d, dt);
// step3 :
StringBuilder R = new StringBuilder();
int n = st.length();
for(int i=0;i<n;i++)
R.append("U");
R.append(dt);
return R.toString();
}
private TreeNode findLCA(TreeNode R, int s, int d) {
if(R == null) return null;
if(R.val == s || R.val == d) return R;
TreeNode Lv = findLCA(R.left, s, d);
TreeNode Rv = findLCA(R.right, s, d);