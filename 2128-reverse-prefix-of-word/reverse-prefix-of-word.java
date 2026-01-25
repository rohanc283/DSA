class Solution {
    public String reversePrefix(String word, char ch) {
        int s = 0, e = -1, n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch) {
                e = i;
                break;
            }
        }
        if (e == -1)
            return word;
        StringBuilder sb = new StringBuilder(word);
        while (s < e) {
            char c = sb.charAt(s);
            sb.setCharAt(s++, sb.charAt(e));
            sb.setCharAt(e--, c);
        }
        return sb.toString();
    }
}