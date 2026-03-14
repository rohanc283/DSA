class Solution {
    int count = 0;
    int K;
    String result;

    private void solve(int n, String curr) {
        if (curr.length() == n) {
            count++;
            if (count == K) {
                result = curr;
            }
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch)
                continue;
            solve(n, curr + ch);
        }
    }

    private String sol1(int n, int k) {
        String curr = "";
        // List<String> result = new ArrayList<>();
        result = "";
        K = k;
        solve(n, curr);
        // if (result.size() < k) {
        //     return "";
        // }
        // return result.get(k - 1);
        return result;
    }

    public String getHappyString(int n, int k) {
        return sol1(n, k);
    }
}