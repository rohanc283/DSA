class Solution {
    private void solve(int n, String curr, List<String> result) {
        if (curr.length() == n) {
            result.add(curr);
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;
            solve(n, curr + ch, result);
        }
    }

    private String sol1(int n, int k) {
        String curr = "";
        List<String> result = new ArrayList<>();
        solve(n, curr, result);
        if (result.size() < k) {
            return "";
        }
        return result.get(k - 1);
    }

    public String getHappyString(int n, int k) {
        return sol1(n, k);
    }
}