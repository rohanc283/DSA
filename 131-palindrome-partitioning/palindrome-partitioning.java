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
            return;
        }
        for (int i = idx; i < n; i++) {
            if (isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));
                solve(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private List<List<String>> sol1(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        n = s.length();
        solve(s, 0, curr, res);
        return res;
    }

    private void solve2(String s, int idx, Boolean[][] dp, List<String> curr, List<List<String>> res) {
        if (idx >= n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = idx; i < n; i++) {
            if (dp[idx][i]) {
                curr.add(s.substring(idx, i + 1));
                solve2(s, i + 1, dp, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private List<List<String>> sol2(String s) {
        n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], false);
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        solve2(s, 0, dp, curr, res);
        return res;
    }

    public List<List<String>> partition(String s) {
        return sol2(s);
    }
}