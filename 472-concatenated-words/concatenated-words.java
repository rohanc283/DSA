class Solution {

    Set<String> dict;
    Map<String, Boolean> memo = new HashMap<>();

    private boolean isConcatenated(String word) {

        if (memo.containsKey(word))
            return memo.get(word);

        int n = word.length();

        for (int i = 1; i < n; i++) {

            String prefix = word.substring(0, i);
            String suffix = word.substring(i);

            if (dict.contains(prefix)) {

                if (dict.contains(suffix) || isConcatenated(suffix)) {
                    memo.put(word, true);
                    return true;
                }
            }
        }

        memo.put(word, false);
        return false;
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        dict = new HashSet<>(Arrays.asList(words));
        List<String> result = new ArrayList<>();

        for (String word : words) {

            dict.remove(word);

            if (isConcatenated(word)) {
                result.add(word);
            }

            dict.add(word);
        }

        return result;
    }
}