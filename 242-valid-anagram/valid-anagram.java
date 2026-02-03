class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] freqS = new int[26];
        int[] freqT = new int[26];
        for (char c : s.toCharArray())
            freqS[c - 'a']++;
        for (char c : t.toCharArray())
            freqT[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (freqS[i] != freqT[i])
                return false;
        }
        return true;
    }
}