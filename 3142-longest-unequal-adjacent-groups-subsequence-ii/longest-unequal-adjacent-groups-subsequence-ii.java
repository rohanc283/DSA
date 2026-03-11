class Solution {
    private int hammingDistance(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i))
                count++;
        }
        return count;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLen = 1, last = 0;
        for (int i = 1; i < n; i++) {
            int curr = 0, k = -1;
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                        words[i].length() == words[j].length() &&
                        hammingDistance(words[i], words[j]) <= 1 && dp[j] > curr) {
                    curr = dp[j];
                    k = j;
                }
            }
            dp[i] += curr;
            parent[i] = k;
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                last = i;
            }
        }
        ArrayList<String> res = new ArrayList<>();
        while (last != -1) {
            res.add(words[last]);
            last = parent[last];
        }
        Collections.reverse(res);
        return res;
    }
}