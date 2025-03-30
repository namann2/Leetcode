class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> recipesThatCanBeCreated = new ArrayList<>();
        // topological sort
        Map<String, List<Integer>> ingredientsRecipeMap = new HashMap<>();
        int n = ingredients.size();
        // indegree array
        int[] indegree = new int[n];
        // consruct ingredient -> List<Recipe> map
        for(int i = 0; i < n; i++) {
            List<String> currIngredientsList = ingredients.get(i);
            indegree[i] = currIngredientsList.size();
            for(String ingredient : currIngredientsList) {
                ingredientsRecipeMap.putIfAbsent(ingredient, new ArrayList<>());
                ingredientsRecipeMap.get(ingredient).add(i);
            }
        }

        // all supplies
        Queue<String> suppliesInHand = new LinkedList<>();
        for(String supply : supplies) 
            suppliesInHand.offer(supply);
        // hashSet
        Set<String> recipesSet = new HashSet<>(Arrays.asList(recipes));

        while(!suppliesInHand.isEmpty()) {
            String currSupply = suppliesInHand.poll();
            if(recipesSet.contains(currSupply)) 
                recipesThatCanBeCreated.add(currSupply);
            if(!ingredientsRecipeMap.containsKey(currSupply)) continue;
            for(int recipeIndex : ingredientsRecipeMap.get(currSupply)) {
                if(--indegree[recipeIndex] == 0) {
                    suppliesInHand.offer(recipes[recipeIndex]);
                    recipesSet.add(recipes[recipeIndex]);
                }
            }
        }

        return recipesThatCanBeCreated;
    }
}