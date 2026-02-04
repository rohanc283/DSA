class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();

        List<Set<String>> sets = new ArrayList<>();
        for (List<String> list : favoriteCompanies) {
            sets.add(new HashSet<>(list));
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boolean isSubset = false;
            for (int j = 0; j < n && !isSubset; j++) {
                if (i == j)
                    continue;
                if (sets.get(j).size() < sets.get(i).size())
                    continue;
                if (sets.get(j).containsAll(sets.get(i)))
                    isSubset = true;
            }
            if (!isSubset) {
                res.add(i);
            }
        }
        return res;
    }
}