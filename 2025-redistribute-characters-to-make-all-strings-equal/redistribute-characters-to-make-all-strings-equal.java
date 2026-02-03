class Solution {
    public boolean makeEqual(String[] words) {
        if (words.length == 1)
            return true;
        int[] freq = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }
        int n = words.length;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0)
                continue;
            if (freq[i] % n != 0)
                return false;
        }
        return true;
    }
}