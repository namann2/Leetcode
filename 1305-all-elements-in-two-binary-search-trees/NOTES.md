https://leetcode.com/problems/all-elements-in-two-binary-search-trees/discuss/1720673/Java-Bonus-or-A-very-detailed-explanation-or-Approach-by-Similarity
​
​
```
```
class Solution {
public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
List<Integer> result = new ArrayList<>();
if(root1 == null && root2 == null) return result;
List<Integer> t1 = new ArrayList<>();
inorder(root1, t1);
List<Integer> t2 = new ArrayList<>();
inorder(root2, t2);
// mer the two lists
int p = 0, q = 0;
while(p < t1.size() && q < t2.size()) {
if(t1.get(p) < t2.get(q)) {
result.add(t1.get(p));
p++;
} else {
result.add(t2.get(q));
q++;
}
}
while(p<t1.size()) {
result.add(t1.get(p++));
}