class Solution {
    public List<String> sol1(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int[][] word1Freq = new int[words1.length][26];
        int[][] word2Freq = new int[words2.length][26];

        for (int i = 0; i < words1.length; i++) {
            for (char c : words1[i].toCharArray()) {
                word1Freq[i][c - 'a']++;
            }
        }

        for (int i = 0; i < words2.length; i++) {
            for (char c : words2[i].toCharArray()) {
                word2Freq[i][c - 'a']++;
            }
        }

        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < words1.length; j++) {
                boolean found = true;
                for (int k = 0; k < 26; k++) {
                    if (word2Freq[i][k] != 0 && word2Freq[i][k] > word1Freq[j][k]) {
                        found = false;
                        break;
                    }
                }
                if (found == true) {
                    map.put(words1[j], map.getOrDefault(words1[j], 0) + 1);
                }
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key) == words2.length)
                res.add(key);
        }
        return res;
    }

    public List<String> sol2(String[] words1, String[] words2) {
        List<String> res = new ArrayList<>();

        int[] word2Freq = new int[26];
        for (int i = 0; i < words2.length; i++) {
            int[] temp = new int[26];
            for (char c : words2[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                word2Freq[j] = Math.max(word2Freq[j], temp[j]);
            }
        }

        for (int i = 0; i < words1.length; i++) {
            int[] word1Freq = new int[26];
            for (char c : words1[i].toCharArray()) {
                word1Freq[c - 'a']++;
            }

            boolean found = true;
            for (int j = 0; j < 26; j++) {
                if (word2Freq[j] > word1Freq[j]) {
                    found = false;
                    break;
                }
            }

            if (found)
                res.add(words1[i]);
        }

        return res;
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {
        return sol2(words1, words2);
    }
}