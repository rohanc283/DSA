class Solution {
    Set<String> exact = new HashSet<>();
    Map<String, String> caseMap = new HashMap<>();
    Map<String, String> vowelMap = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        for (String w : wordlist) {
            exact.add(w);

            String lower = w.toLowerCase();
            caseMap.putIfAbsent(lower, w);

            String devowel = lower.replaceAll("[aeiou]", "#");
            vowelMap.putIfAbsent(devowel, w);
        }

        String[] res = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];

            if (exact.contains(q)) {
                res[i] = q;
                continue;
            }

            String lower = q.toLowerCase();
            if (caseMap.containsKey(lower)) {
                res[i] = caseMap.get(lower);
                continue;
            }

            String devowel = lower.replaceAll("[aeiou]", "#");
            if (vowelMap.containsKey(devowel)) {
                res[i] = vowelMap.get(devowel);
                continue;
            }

            res[i] = "";
        }

        return res;
    }
}