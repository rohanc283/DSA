class Solution {

    private void reverse(StringBuilder sb, int l, int r) {
        while (l < r) {
            char temp = sb.charAt(l);
            sb.setCharAt(l++, sb.charAt(r));
            sb.setCharAt(r--, temp);
        }
    }

    public String reverseWords(String str) {
        StringBuilder sb = new StringBuilder(str);
        int start = 0;

        for (int i = 0; i <= sb.length(); i++) {
            if (i == sb.length() || sb.charAt(i) == ' ') {
                reverse(sb, start, i - 1);
                start = i + 1;
            }
        }
        return sb.toString();
    }
}
