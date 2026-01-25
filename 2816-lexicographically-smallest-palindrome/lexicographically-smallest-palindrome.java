class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = sb.length() - 1;
        while (l < r) {
            char lc = sb.charAt(l), rc = sb.charAt(r);
            if (lc != rc) {
                if (lc < rc) {
                    sb.setCharAt(l, lc);
                    sb.setCharAt(r, lc);
                } else {
                    sb.setCharAt(l, rc);
                    sb.setCharAt(r, rc);
                }
            }
            l++;
            r--;
        }
        return sb.toString();
    }
}