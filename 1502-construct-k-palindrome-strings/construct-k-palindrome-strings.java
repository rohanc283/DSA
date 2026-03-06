class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() == k)
            return true;
        if (s.length() < k)
            return false;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int oddFreqCount = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0)
                oddFreqCount++;
        }
        return oddFreqCount <= k;
    }
}