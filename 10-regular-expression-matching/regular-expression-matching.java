class Solution {

    private boolean solve(String s, String p, int i, int j) {
        if (i < 0 && j < 0)
            return true;

        if (j < 0)
            return false;

        if (i < 0) {
            if (p.charAt(j) == '*')
                return solve(s, p, i, j - 2);
            return false;
        }

        boolean ans = false;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            ans = solve(s, p, i - 1, j - 1);
        } else if (p.charAt(j) == '*') {
            ans = solve(s, p, i, j - 2);
            char prev = p.charAt(j - 1);
            if (!ans && (prev == '.' || prev == s.charAt(i)))
                ans = solve(s, p, i - 1, j);
        }

        return ans;
    }

    public boolean isMatch(String s, String p) {
        return solve(s, p, s.length() - 1, p.length() - 1);
    }
}