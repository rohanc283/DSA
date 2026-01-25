class Solution {
    public String reverseWords(String str) {
        StringBuilder sb = new StringBuilder(str);
        int s = 0, n = sb.length();
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ' ') {
                s = i + 1;
                continue;
            }
            if (i == n - 1 || sb.charAt(i + 1) == ' ') {
                int x = s, y = i;
                while (x < y) {
                    char c = sb.charAt(x);
                    sb.setCharAt(x++, sb.charAt(y));
                    sb.setCharAt(y--, c);
                }
                s = i + 1;
            }
        }
        return sb.toString();
    }
}