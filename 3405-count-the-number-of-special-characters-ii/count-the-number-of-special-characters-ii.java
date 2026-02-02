class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lower[c - 'a'] = i;
            } else {
                if (upper[c - 'A'] == -1)
                    upper[c - 'A'] = i;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] == -1 || upper[i] == -1)
                continue;
            if (lower[i] > upper[i])
                continue;
            if (lower[i] < upper[i])
                count++;
        }
        return count;
    }
}