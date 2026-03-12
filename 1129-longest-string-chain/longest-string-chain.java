class Solution {
    private boolean isValid(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if (n + 1 != m)
            return false;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j >= n;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                if (isValid(words[i], words[j])) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            dp[i] += curr;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}