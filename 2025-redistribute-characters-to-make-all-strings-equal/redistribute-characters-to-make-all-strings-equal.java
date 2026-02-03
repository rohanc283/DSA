class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        if (n == 1)
            return true;

        int[] freq = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
        }

        for (int count : freq) {
            if (count % n != 0)
                return false;
        }
        return true;
    }
}
