```
class Solution {
/*
Let N be the number of input equations/pairs we are given and M be the number of queries.
​
Time Complexity: O(M⋅N)
*/
public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
HashMap<String, List<Pair>> adj = new HashMap<>();
// build graph
buildGraph(adj, equations, values);
int n = queries.size();
double [] result = new double[n];
for(int i=0;i<n;i++) {
List<String> curr = queries.get(i);
// if(!visited.contains(curr.get(0))) { // doing this will skip few queries because of nodes being visited
result[i] = dfs(curr.get(0), curr.get(1), adj, new HashSet<>());
// }
}
return result;
}
private void buildGraph(HashMap<String, List<Pair>> adj, List<List<String>> equations, double[] values) {