class Solution {
    public void reverse(StringBuilder sb, int s, int e) {
        while (s < e) {
            char c = sb.charAt(s);
            sb.setCharAt(s++, sb.charAt(e));
            sb.setCharAt(e--, c);
        }
    }

    public String reverseWords(String str) {
        StringBuilder sb = new StringBuilder(str);
        int s = 0, n = sb.length();
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ' ') {
                s = i + 1;
                continue;
            }
            if (i == n - 1 || sb.charAt(i + 1) == ' ') {
                reverse(sb, s, i);
                s = i + 1;
            }
        }
        return sb.toString();
    }
}