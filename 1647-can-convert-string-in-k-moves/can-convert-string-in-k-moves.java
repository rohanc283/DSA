class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length())
            return false;

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (a == b)
                continue;

            int diff = (b - a + 26) % 26;

            int moveTime = diff + 26 * freq[diff];
            if (moveTime > k)
                return false;

            freq[diff]++;
        }
        return true;
    }
}
