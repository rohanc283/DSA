class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray())
            freq[c - 'a']++;
        StringBuilder res = new StringBuilder();
        while (true) {
            boolean isEmpty = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    char c = (char) ('a' + i);
                    res.append(c);
                    freq[i]--;
                    isEmpty = false;
                }
            }
            if (isEmpty)
                break;

            isEmpty = true;
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    char c = (char) ('a' + i);
                    res.append(c);
                    freq[i]--;
                    isEmpty = false;
                }
            }
            if (isEmpty)
                break;
        }
        return res.toString();
    }
}