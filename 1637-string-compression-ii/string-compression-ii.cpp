int dp[101][27][101][101];
class Solution {
public:
    int solve(int i, int prev_char, int freq, int k, string& s) {
        if (k < 0)
            return INT_MAX;
        if (i >= s.size())
            return 0;
        if (dp[i][prev_char][freq][k] != -1)
            return dp[i][prev_char][freq][k];
        int del = solve(i + 1, prev_char, freq, k - 1, s);
        int keep = 0;
        if (s[i] - 'a' != prev_char) {
            keep = 1 + solve(i + 1, s[i] - 'a', 1, k, s);
        } else {
            int oneMoreAdd = 0;
            if (freq == 1 || freq == 9 || freq == 99)
                oneMoreAdd = 1;
            keep = oneMoreAdd + solve(i + 1, prev_char, freq + 1, k, s);
        }
        return dp[i][prev_char][freq][k] = min(del, keep);
    }
    int getLengthOfOptimalCompression(string s, int k) {
        memset(dp, -1, sizeof(dp));
        return solve(0, 26, 0, k, s);
    }
};