class Solution {
    public String makeSmallestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        StringBuilder res = new StringBuilder(s);
        while (i < j) {
            char c1 = res.charAt(i), c2 = res.charAt(j);
            if (c1 != c2) {
                if (c1 < c2) {
                    res.setCharAt(j, c1);
                } else {
                    res.setCharAt(i, c2);
                }
            }
            i++;
            j--;
        }
        return res.toString();
    }
}