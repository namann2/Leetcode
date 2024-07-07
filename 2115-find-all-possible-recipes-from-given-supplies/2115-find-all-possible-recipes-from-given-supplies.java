class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> recipesIndex = new HashMap<>();
        int n = recipes.length;
        // create a map of recipe -> index of recipe in recipes[i]
        for(int i = 0; i < n; i++)
            recipesIndex.put(recipes[i], i);
        
        // update the indegree of recipes
        int[] indegree = new int[n];
        
        // map of ingredient -> recipe
        Map<String, List<Integer>> ingredientsRecipe = new HashMap<>();
        
        int in = ingredients.size();
        for(int i = 0; i < in; i++) {
            indegree[i] = ingredients.get(i).size();
            for(String ingredient : ingredients.get(i)) {
                ingredientsRecipe.putIfAbsent(ingredient, new ArrayList<>());
                ingredientsRecipe.get(ingredient).add(i);
            }
        }
        
        // iterate with all the supplies
        Queue<String> suppliesInHand = new LinkedList<>();
        for(String supply : supplies) 
            suppliesInHand.offer(supply);
        
        List<String> receipesThatCanBeCreated = new ArrayList<>();
        
        while(!suppliesInHand.isEmpty()) {
            String currSupply = suppliesInHand.remove();
            if(ingredientsRecipe.containsKey(currSupply)) {
                for(int recipeIndex : ingredientsRecipe.get(currSupply)) {
                    indegree[recipeIndex]--;
                    if(indegree[recipeIndex] == 0) {
                        receipesThatCanBeCreated.add(recipes[recipeIndex]);
                        suppliesInHand.offer(recipes[recipeIndex]);
                    }
                }
            }
        }
        
        return receipesThatCanBeCreated;
    }
}