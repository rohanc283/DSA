class Solution {
    public boolean isGood(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 1)
                return false;
        }
        return true;
    }

    public int countGoodSubstrings(String s) {
        if (s.length() < 3)
            return 0;
        int[] freq = new int[26];
        int i = 0, j = 0;
        while (j < 3) {
            freq[s.charAt(j++) - 'a']++;
        }

        j--;
        int count = 0;
        while (j < s.length()) {
            if (isGood(freq))
                count++;
            freq[s.charAt(i++) - 'a']--;
            j++;
            if (j < s.length()) {
                freq[s.charAt(j) - 'a']++;
            }
        }
        return count;
    }
}