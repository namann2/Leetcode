```
class Solution {
public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
List<String> result = new ArrayList<>();
// create graph
// ArrayList<ArrayList<String>> adj = new ArrayList();
HashMap<String, List<String>> map` = new HashMap<>(); // graph
HashMap<String, Integer> indegree = new HashMap<>(); // node and indegree
int N = recipes.length;
// construct graph
for(int i=0;i<N;i++)
{   //mapping is ingredient -> recipe
List<String> In = ingredients.get(i);
indegree.put(recipes[i], indegree.getOrDefault(recipes[i], 0)+In.size());
for(String ing : In) {
if(!map.containsKey(ing))
map.put(ing, new ArrayList<String>());
map.get(ing).add(recipes[i]);
}
}
// initially we have a list of supplies to start from