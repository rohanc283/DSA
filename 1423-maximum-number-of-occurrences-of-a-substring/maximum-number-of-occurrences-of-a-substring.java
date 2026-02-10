class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length();
        Map<String, Integer> countMap = new HashMap<>();
        int[] freq = new int[26];
        int distinct = 0;

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (++freq[s.charAt(j) - 'a'] == 1)
                distinct++;

            if (j - i + 1 > minSize) {
                if (--freq[s.charAt(i) - 'a'] == 0)
                    distinct--;
                i++;
            }

            if (j - i + 1 == minSize && distinct <= maxLetters) {
                String sub = s.substring(i, j + 1);
                countMap.put(sub, countMap.getOrDefault(sub, 0) + 1);
            }
        }

        int res = 0;
        for (int v : countMap.values())
            res = Math.max(res, v);
        return res;
    }
}