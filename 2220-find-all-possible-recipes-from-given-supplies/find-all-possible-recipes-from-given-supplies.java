class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> suppliesSet = new HashSet<>();
        for (String supp : supplies)
            suppliesSet.add(supp);

        List<String> result = new ArrayList<>();
        boolean[] cooked = new boolean[n];
        int count = n;
        while (count-- > 0) {
            for (int i = 0; i < recipes.length; i++) {
                if (cooked[i])
                    continue;
                boolean canBeMade = true;
                for (int j = 0; j < ingredients.get(i).size(); j++) {
                    if (!suppliesSet.contains(ingredients.get(i).get(j))) {
                        canBeMade = false;
                        break;
                    }
                }
                if (canBeMade) {
                    result.add(recipes[i]);
                    suppliesSet.add(recipes[i]);
                    cooked[i] = true;
                }
            }
        }
        return result;
    }
}