class Solution {
    public List<String> sol1(String[] words) {
        StringBuilder sb1 = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++) {
            StringBuilder sb2 = new StringBuilder(words[i]);
            for (int j = 0; j < sb1.length(); j++) {
                int k = sb2.indexOf(String.valueOf(sb1.charAt(j)));
                if (k != -1) {
                    sb2.deleteCharAt(k);
                } else {
                    sb1.deleteCharAt(j);
                    j--;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < sb1.length(); i++) {
            res.add(String.valueOf(sb1.charAt(i)));
        }
        return res;
    }

    public List<String> sol2(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        for (String word : words) {
            int[] freq = new int[26];
            for (Character c : word.toCharArray()) {
                freq[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i]-- > 0) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }
        return res;
    }

    public List<String> commonChars(String[] words) {
        return sol2(words);
    }
}