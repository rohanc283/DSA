class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length())
            return false;
        int[] freq = new int[27];
        for (int i = 1; i < 26; i++) {
            int div = k / 26;
            int rem = k % 26;
            freq[i] += div;
            if (i <= rem) {
                freq[i]++;
            }
        }
        int n = s.length();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (c1 != c2) {
                int diff = (c2 - c1 + 26) % 26;
                if (freq[diff] <= 0)
                    return false;
                freq[diff]--;
            }
        }
        return true;
    }
}