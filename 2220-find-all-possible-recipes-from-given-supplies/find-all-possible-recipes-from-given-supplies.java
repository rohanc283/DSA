class Solution {
    private List<String> sol1(String[] recipes, List<List<String>> ingredients, String[] supplies) {
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

    public List<String> sol2(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String> suppliesSet = new HashSet<>();
        for (String supp : supplies)
            suppliesSet.add(supp);

        Map<String, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (String ingredient : ingredients.get(i)) {
                if (!suppliesSet.contains(ingredient)) {
                    graph.computeIfAbsent(ingredient, a -> new ArrayList<>()).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int f = queue.poll();
            String recipe = recipes[f];
            result.add(recipe);
            for (Integer nei : graph.getOrDefault(recipe, new ArrayList<>())) {
                indegree[nei]--;
                if (indegree[nei] == 0)
                    queue.offer(nei);
            }

        }
        return result;
    }

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        return sol2(recipes, ingredients, supplies);
    }
}