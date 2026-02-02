class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charsFreq = new int[26];
        for (char c : chars.toCharArray()) {
            charsFreq[c - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] wordFreq = new int[26];
            for (char c : word.toCharArray()) {
                wordFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (wordFreq[i] > charsFreq[i])
                    break;
                if (i == 25)
                    res += word.length();
            }
        }
        return res;
    }
}