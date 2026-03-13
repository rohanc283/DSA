class Solution {
    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    int n;

    private void solve(String s, int idx, List<String> curr, List<List<String>> res) {
        if (idx >= n) {
            res.add(new ArrayList<>(curr));
        }
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                solve(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        n = s.length();
        solve(s, 0, curr, res);
        return res;
    }
}