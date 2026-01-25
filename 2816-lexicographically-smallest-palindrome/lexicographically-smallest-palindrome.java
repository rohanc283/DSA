class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = sb.length() - 1;

        while (l < r) {
            char c = (char) Math.min(sb.charAt(l), sb.charAt(r));
            sb.setCharAt(l++, c);
            sb.setCharAt(r--, c);
        }
        return sb.toString();
    }
}
