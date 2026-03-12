class Solution {

    Set<String> dict;
    int N;
    Map<Integer, List<String>> memo = new HashMap<>();

    private List<String> solve(String s, int i) {

        if (memo.containsKey(i))
            return memo.get(i);

        List<String> result = new ArrayList<>();

        if (i == N) {
            result.add("");
            return result;
        }

        for (int len = 1; i + len <= N; len++) {

            String word = s.substring(i, i + len);

            if (dict.contains(word)) {

                List<String> rest = solve(s, i + len);

                for (String r : rest) {

                    if (r.isEmpty())
                        result.add(word);
                    else
                        result.add(word + " " + r);
                }
            }
        }

        memo.put(i, result);
        return result;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        dict = new HashSet<>(wordDict);
        N = s.length();

        return solve(s, 0);
    }
}