class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        while (n > 1) {
            if (s.charAt(0) != s.charAt(n - 1))
                break;

            int l = 0;
            while (l < n && s.charAt(l) == s.charAt(0))
                l++;

            int r = s.length() - 1;
            while (r >= 0 && s.charAt(r) == s.charAt(n - 1))
                r--;
            if (l > r)
                return 0;
            s = s.substring(l, r + 1);
            n = s.length();
        }
        return s.length();
    }
}