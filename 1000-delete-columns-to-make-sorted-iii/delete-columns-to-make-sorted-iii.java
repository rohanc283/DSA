class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int cols = strs[0].length();
        int[] dp = new int[cols];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < cols; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                boolean isValid = true;
                for (int k = 0; k < n; k++) {
                    if (strs[k].charAt(j) > strs[k].charAt(i)) {
                        isValid = false;
                        break;
                    }
                }
                if (isValid) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            dp[i] += curr;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return cols - maxLen;
    }
}