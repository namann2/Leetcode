```
class Pair {
int val, lvl, hdis;
Pair(int val, int lvl, int hdis) {
this.val = val;
this.lvl = lvl;
this.hdis = hdis;
}
}
class Solution {
public List<List<Integer>> verticalOrder(TreeNode root) {
List<List<Integer>> result = new ArrayList();
if(root == null) return result;
TreeMap<Integer, ArrayList<Pair>> map = new TreeMap();
dfs(root, 0, 0, map);
for(int hdis : map.keySet()) {
ArrayList<Pair> temp = map.get(hdis);
ArrayList<Integer> t = new ArrayList<>();
for(Pair p : temp) {
t.add(p.val);
}
result.add(t);
}
return result;